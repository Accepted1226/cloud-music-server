package com.xxx.customer.controller;

import com.xxx.constant.Constants;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import lombok.Value;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import com.xxx.common.SuccessMessage;
import com.xxx.common.ErrorMessage;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.apache.commons.io.FilenameUtils;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.UUID;
/**
 * @Author lsc
 * @Description <p> </p>
 * @Date 2019/10/2 20:58
 * @Version 1.0
 */
@RestController
public class FileUploadController {



    //todo:返回的是绝对路径
    @PostMapping("/v1/r/multi")
    public Object fileUpload(@RequestParam("file") MultipartFile[] files) throws IOException {
        //,@RequestParam(value = "flavor",required = false)String flavor建议不传
        String fileRootPath=System.getProperty("user.dir")+"/feed/";
        //多文件上传
        int length=files.length;
        System.out.println(length);
        List<String> list=new ArrayList<String>();
        for (MultipartFile file : files){
            // 上传简单文件名
            //String filePath = "";
            String originalFilename = file.getOriginalFilename();
            //String fileType=originalFilename.substring(originalFilename.lastIndexOf("."),originalFilename.length());
            //System.out.println(fileType);
            //System.out.println(fileType.equals(".jpg"));
            //System.out.println(fileType.equals(".jpeg"));
            //System.out.println(fileType.equals(".png"));
            //System.out.println(fileType.equals(".jpg")||fileType.equals(".jpeg")||fileType.equals(".png"));

            //获取文件后缀名
            String extension = FilenameUtils.getExtension(originalFilename); //jpg
            if(!(extension.equals("jpg")||extension.equals("jpeg")||extension.equals("png"))){
                return new ErrorMessage("请上传正确的图片类型").getMessage();
            }
            //获取新文件名称 命名：时间戳+UUID+后缀
            String newFileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())
                    + UUID.randomUUID().toString().substring(0, 4)
                    + "."
                    +extension;
            String path = Constants.PROJECT_PATH+"/img/feed/";
            System.out.println(Constants.PROJECT_PATH);
            //新建一个时间文件夹标识，用来分类
            String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            //全路径(存放资源的路径) 资源路径+时间文件夹标识
            String dataDir = path + format;
            System.out.println(dataDir);

            //全路径存放在文件类中，判断文件夹是否存在不存在就创建
            File dataFile = new File(dataDir);  //也可以直接放进去进行拼接 File dataFile = new File(path,format);
            if (!dataFile.exists()) {
                dataFile.mkdirs();
            }
            String relativePath= "/img/feed/"+format+"/"+newFileName;
            list.add(relativePath);
            //文件上传至指定路径
            file.transferTo(new File(dataFile, newFileName));
        }
        System.out.println(list);
        return new SuccessMessage<List<String>>(list,length,"上传成功").getMessage();
    }

//
//    @PostMapping("/upload")
//    public String upload(HttpSession session, @RequestParam("file") MultipartFile file, RedirectAttributes attributes) throws IOException {
//        System.out.println("准备上传");
//        if (file.isEmpty()) {
//            attributes.addFlashAttribute("msg", "上传的文件不能为空");
//            return "redirect:/files/fileAll";
//        }
//
//        //获取原始文件名称
//        String originalFilename = file.getOriginalFilename();
//
//        //获取文件后缀名
//        String extension = "." + FilenameUtils.getExtension(originalFilename); //.jpg
//        //获取新文件名称 命名：时间戳+UUID+后缀
//        String newFileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())
//                + UUID.randomUUID().toString().substring(0, 4)
//                + extension;
//
//        //获取资源路径 classpath的项目路径+/static/files  classpath就是resources的资源路径
//        String path = ResourceUtils.getURL("classpath:").getPath() + "static/files/";
//
//
//
//    }
//


}