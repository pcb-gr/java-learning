package example.http.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.apache.tomcat.util.http.fileupload.IOUtils;

public class HttpsClient {

	String storePath = "G:\\SSD-CP\\D-hard-disk\\servers\\httpd-2.4.33-o102o-x86-vc14-r2\\Apache24\\htdocs\\ts-video-demo\\";
	public static void main(String[] args) {
		new HttpsClient().doTask();
	}

	private void doTask() {
		// joinPartToMp4("temp");
		// first: get m3u8 file
		String m3u8Url = "https://storage.googleapis.com/hachium/streaming/6658b9fc85f4057438ff6ace48582306/1523430773559/360.m3u8";
		String m3u8Content = getContentFile(m3u8Url);
		String key = getContentFile("http://khoahoc.fedu.vn/lecture/get_streaming_key");
		//m3u8Content = removeEXTXKEY(m3u8Content);
		writeStringToFile(m3u8Content, storePath + "seglist_720p.m3u8");
		List<String> tsList = collectTsFiles(m3u8Content);
		if (tsList.size() > 0) {
			String serverPath = m3u8Url.substring(0, m3u8Url.lastIndexOf('/'));
			boolean isSuccess = downloadTsFiles(tsList, serverPath);
			if (isSuccess) {
				joinPartToMp4("temp");
			}
		}
	}

	private boolean downloadTsFiles(List<String> tsList, String serverPath) {
		try {
			for (int i = 0; i < tsList.size(); i++) {
				String tsName = tsList.get(i);
				Object con = httpConnFactory.getConn(serverPath + "/" + tsName);
				if (con != null) {
					writeStreamToFile(con, storePath + tsName);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private boolean joinPartToMp4(String tempPath) {
		try {
			executeCommand("ffmpeg -i temp/playlist.m3u8 -c copy -bsf:a aac_adtstoasc temp/output.mp4");
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	private String executeCommand(String command) throws Exception {

		StringBuffer output = new StringBuffer();

		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

			String line = "";
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
				System.out.println(line + "\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return output.toString();

	}

	private String removeEXTXKEY(String m3u8Content) {
		// first: get m3u8 file
		String[] parts = m3u8Content.split("\n");
		List<String> tsList = new ArrayList<String>();
		for (int i = 0; i < parts.length; i++) {
			String part = parts[i];
			if (!part.contains("EXT-X-KEY")) {
				tsList.add(part);
			}
		}
		return String.join("\n", tsList);
	}
	
	private String getEXTXKEY(String m3u8Content) {
		// first: get m3u8 file
		String[] parts = m3u8Content.split("\n");
		for (int i = 0; i < parts.length; i++) {
			String part = parts[i];
			if (!part.contains("EXT-X-KEY")) {
				return part;
			}
		}
		return "";
	}

	private List<String> collectTsFiles(String m3u8Content) {
		// first: get m3u8 file
		String[] parts = m3u8Content.split("\n");
		List<String> tsList = new ArrayList<String>();
		for (int i = 0; i < parts.length; i++) {
			String part = parts[i];
			if (part.contains(".ts")) {
				tsList.add(part);
			}
		}
		return tsList;
	}

	private String getContentFile(String path) {

		String content = "";
		Object con = httpConnFactory.getConn(path);
		if (con != null) {
			System.out.println("****** Content of the URL ********");
			BufferedReader bufferedReader = null;
			try {
				bufferedReader = new BufferedReader(new InputStreamReader(httpConnFactory.getInputStream(con)));
				String s = "";
				while ((s = bufferedReader.readLine()) != null) {
					content += s + "\n";
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				// close without throwing exception
				IOUtils.closeQuietly(bufferedReader);
			}
		}
		return content;
	}

	private boolean writeStringToFile(String content, String path) {
		try {
			File file = new File(path);
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(content);
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private void writeStreamToFile(Object con, String path) {
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(httpConnFactory.getInputStream(con)));
			bufferedWriter = new BufferedWriter(new FileWriter(path));
			String s = "";
			while ((s = bufferedReader.readLine()) != null) {
				bufferedWriter.write(s);
				// write a new line
				bufferedWriter.newLine();
				// flush
				bufferedWriter.flush();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// close without throwing exception
			IOUtils.closeQuietly(bufferedReader);
			IOUtils.closeQuietly(bufferedWriter);
		}

	}

	static class httpConnFactory {

		public static Object getConn(String path) {

			try {
				URL url = new URL(path);
				if (path.indexOf("https") != -1) {
					return (HttpsURLConnection) url.openConnection();
				} else {
					return (HttpURLConnection) url.openConnection();
				}

			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}

		}
		
		public static InputStream getInputStream(Object conn) {

			try {
				if (conn instanceof HttpsURLConnection) {
					return ((HttpsURLConnection) conn).getInputStream();
				} else {
					return ((HttpURLConnection) conn).getInputStream();
				}

			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}

		}

	}

}
