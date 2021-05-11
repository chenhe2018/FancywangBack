package com.example.demo.controler;

import com.google.gson.Gson;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

@RestController
public class HelloRest {
	private Logger logger = LoggerFactory.getLogger(getClass());
	Gson gson = new Gson();
	
	@RequestMapping(value = "/hello",method=RequestMethod.GET)
	public String hello(){
		return "spring hello";
	}

	@RequestMapping(value = "/world",method=RequestMethod.POST)
	public String world(){
		return "spring world";
	}
	
	@RequestMapping(value = "/json",method=RequestMethod.GET)
	public RtnPojo json(){
		RtnPojo rtnPojo = new RtnPojo("success");
		return rtnPojo;
	}
	@RequestMapping(value = "/download",method=RequestMethod.POST)
	public void download(HttpServletRequest req, HttpServletResponse res, @RequestBody String json) throws UnsupportedEncodingException {

		logger.info("download {}",gson.toJson(json));

		String downloadFilename = "zip1";
		res.setContentType("application/octet-stream");
		res.setHeader("Content-Disposition", "attachment;filename=" + downloadFilename+".zip");


		String [] filepaths = {"C:/Users/Administrator/Desktop/1.txt","C:/Users/Administrator/Desktop/2.txt"};

		OutputStream outputStream = null;
		ZipOutputStream zipOutputStream = null;
		ByteArrayOutputStream baos = null;
		FileInputStream fileInputStream = null;
		try{
			//批量填充zip包
			zipOutputStream = new ZipOutputStream(res.getOutputStream());

			for(String filepath:filepaths){
				fileInputStream = new FileInputStream(new File(filepath));
				String[] split = filepath.split("/");
				String filename = split[split.length - 1];

				//读入数据至byte流
				baos = new ByteArrayOutputStream();
				int len = 0;
				byte[] buffer = new byte[10 * 1024];
				while ((len = fileInputStream.read(buffer,0,buffer.length)) > 0) {
					baos.write(buffer,0, len);
				}

				//写入至zip节点
				ZipEntry zipEntry = new ZipEntry(filename);
				zipOutputStream.putNextEntry(zipEntry);
				byte[] bytes = baos.toByteArray();
				zipOutputStream.write(bytes);
				zipOutputStream.closeEntry();
				logger.info("filename {} bytes {}", filename, bytes);

				baos.close();
			}
			outputStream.flush();
			zipOutputStream.close();
			outputStream.close();

		}catch (Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(zipOutputStream != null){
					zipOutputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(outputStream != null){
					outputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


	@RequestMapping(value = "/download2",method=RequestMethod.POST)
	public void download2(HttpServletRequest req, HttpServletResponse res, @RequestBody String json) throws UnsupportedEncodingException {
		try {
			// The path below is the root directory of data to be
			// compressed.
			String [] filepaths = {"C:/Users/Administrator/Desktop/1.txt","C:/Users/Administrator/Desktop/2.txt"};

			byte[] zip = zipFiles(filepaths);
			logger.info("zip {}",zip);
			String downloadFilename = "ziptest";

			OutputStream sos = res.getOutputStream();
			res.reset();

			res.setContentType("APPLICATION/OCTET-STREAM");
			res.setHeader("Content-Disposition","attachment; filename=code.zip");

			sos.write(zip);
			res.flushBuffer();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Compress the given directory with all its files.
	 */
	private byte[] zipFiles(String[] files) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ZipOutputStream zos = new ZipOutputStream(baos);
		byte bytes[] = new byte[2048];

		for (String fileName : files) {
			FileInputStream fis = new FileInputStream(fileName);
			BufferedInputStream bis = new BufferedInputStream(fis);

			zos.putNextEntry(new ZipEntry(fileName));

			int bytesRead;
			while ((bytesRead = bis.read(bytes)) != -1) {
				zos.write(bytes, 0, bytesRead);
			}
			zos.closeEntry();
			bis.close();
			fis.close();
		}
		zos.flush();
		baos.flush();
		zos.close();
		baos.close();

		return baos.toByteArray();
	}
}
