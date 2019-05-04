package com.qhit.utils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.UUID;

/**
 * Created by yy on 2018/11/5.
 */
@WebServlet(name = "File",urlPatterns = "/wenjian")
public class File extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = request.getSession().getServletContext().getRealPath("upload");
        //获取输出流
        ServletInputStream neirong = request.getInputStream();
        FileOutputStream fos = new FileOutputStream(path+"\\test1.txt");
        int b;
        while ((b=neirong.read())!=-1){
            fos.write(b);
        }
        neirong.close();
        fos.close();

        //创建RandomAccessFile
        RandomAccessFile randomAccessFile = new RandomAccessFile(path+"\\test1.txt","r");
        //去掉前四行
        String firstLine = randomAccessFile.readLine();//第一行
        String secondLine = randomAccessFile.readLine();//第二行
        secondLine =new String( secondLine.getBytes("iso-8859-1"),"utf-8");
        String[] arr = secondLine.split("; ");//按; 拆分
        String filename = arr[2].substring(10, arr[2].length() - 1);//截取arr[2]的内容和名字唯一
        String name = arr[1].substring(6,arr[1].length()-1);
        String thirdLine = randomAccessFile.readLine();//第三行
        randomAccessFile.readLine();//第四行

        //获取输入流中内容长度
        int length = request.getContentLength();
        int realLength = length - firstLine.getBytes("utf-8").length
                -secondLine.getBytes("utf-8").length
                -thirdLine.getBytes("utf-8").length
                - firstLine.getBytes("utf-8").length-2-12;

        FileOutputStream fos1 = new FileOutputStream(path+"\\"+filename);
        int count=0;
        while ((b=randomAccessFile.read())!=-1){
            fos1.write(b);
            count++;
            if(count==realLength){
                break;
            }
        }
        randomAccessFile.close();
        fos1.close();
        request.setAttribute("filename",filename);
        request.setAttribute("name",name);
        request.getRequestDispatcher("file/message.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
