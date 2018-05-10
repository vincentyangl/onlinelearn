package com.controller.back;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Edu_website_images;
import com.bean.Edu_website_images_type;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.Edu_website_imagesService;
import com.service.Edu_website_images_typeService;

@Controller
@RequestMapping("/admin/imge")
public class Edu_website_imgesController { //图片管理

	  @Autowired
	  private Edu_website_imagesService edu_website_imagesService;
	  @Autowired 
	  private  Edu_website_images_typeService edu_website_images_typeService;
	  
	  @RequestMapping("/imagesPage")
	  public ModelAndView list(@RequestParam(required=true,defaultValue="1")Integer page, HttpServletRequest request) {
		 ModelAndView mv=new ModelAndView();
		 PageHelper.startPage(page,10);
		 Map map=new HashMap<>();
		 map=initMap(request, map);
		 List<Edu_website_images>list=edu_website_imagesService.listAll(map);
		 PageInfo<Edu_website_images>pageInfo=new PageInfo<>(list);
		 List<Edu_website_images_type>type=edu_website_images_typeService.listAll();
		 mv.addObject("list", list);
		 mv.addObject("page", pageInfo);
		 mv.addObject("type", type);
		 mv.setViewName("/back/imges/imagesPage");
		 return mv;
	}
	 
	  
	  public Map initMap(HttpServletRequest request,Map map) {
		   String qname=request.getParameter("qname");
		   String type_id=request.getParameter("type_id");
		   map.put("qname", qname);
		   map.put("type_id", type_id);
		   return map;
	}
	  @RequestMapping("/option")
	  public ModelAndView option() {
		ModelAndView mv=new ModelAndView();
		 List<Edu_website_images_type>type=edu_website_images_typeService.listAll();  
		 mv.addObject("type", type);
		 mv.setViewName("/back/imges/imagesSave");
		return mv;
	}
	  
	  @RequestMapping("/index")
		public String index(){
			return "upload";
		}
		
		@RequestMapping(value="/upload",method=RequestMethod.POST)
		public ModelAndView upload(@RequestParam("image_url")MultipartFile image_url, HttpServletRequest request){
			ModelAndView mv=new ModelAndView();
			Edu_website_images img=new Edu_website_images();
			String title=request.getParameter("title");
			String describes=request.getParameter("describes");
			String type_id=request.getParameter("type_ids");
			Edu_website_images_type type=edu_website_images_typeService.getById(Integer.valueOf(type_id));
			String link_address=request.getParameter("link_address");
			String series_number=request.getParameter("series_number");
			String color=request.getParameter("color");
			String filename=image_url.getOriginalFilename();
			//upload文件夹的路径
			
			String path=request.getRealPath("/images/upload/image/20180408/");
			File newfile=new File(path,filename);
			try{
				//将客户端上传的文件复制到服务器中
				image_url.transferTo(newfile);
			}catch(Exception e){
				e.printStackTrace();
			}
			img.setTitle(title);
			img.setDescribes(describes);
			img.setLink_address(link_address);
			img.setImage_url("/images/upload/image/20180408/"+filename);
			img.setPreview_url("/images/upload/image/20180408/"+filename);
			img.setSeries_number(Integer.parseInt(series_number));
			img.setColor(color);
			img.setType_id(type);
			edu_website_imagesService.save(img);
			mv.setViewName("redirect:/admin/imge/imagesPage");
			return mv;
		}
		
	    @RequestMapping("/update/{imge_id}")
		public ModelAndView update(@PathVariable("imge_id") int imge_id) {
	    	ModelAndView mv=new ModelAndView();
	    	  Edu_website_images list=edu_website_imagesService.getById(imge_id);
	    	  List<Edu_website_images_type> type=edu_website_images_typeService.listAll();
	    	  mv.addObject("list", list);
	    	  mv.addObject("type", type);
	    	  mv.setViewName("/back/imges/imagesEdit");
	    	return mv;
		}
	    
	    @RequestMapping(value="/toupdate",method=RequestMethod.POST)
	    public String toupdate(@RequestParam("file1")MultipartFile file1,Edu_website_images edu_website_images,HttpServletRequest request) {
	    	 String type_id=request.getParameter("type_ids");
	    	 String hiddens=request.getParameter("hiddens");
	    	 Edu_website_images_type type=new Edu_website_images_type();
	    	 type.setType_id(Integer.valueOf(type_id));
	    	 edu_website_images.setType_id(type);
	    	 String filename=file1.getOriginalFilename();
	    	 String path=request.getRealPath("/images/upload/image/20180408/");
	    	 File newfile=new File(path,filename);
	    	 if (filename.equals("")|| filename==null) {
	    		 edu_website_images.setImage_url("/images/upload/image/20180408/"+hiddens);
				 edu_website_images.setPreview_url("/images/upload/image/20180408/"+hiddens);
			}else {
				try{
					//将客户端上传的文件复制到服务器中
					file1.transferTo(newfile);
				}catch(Exception e){
					e.printStackTrace();
				}
				edu_website_images.setImage_url("/images/upload/image/20180408/"+filename);
				edu_website_images.setPreview_url("/images/upload/image/20180408/"+filename);
			}
			edu_website_imagesService.update(edu_website_images);
			return "redirect:/admin/imge/imagesPage";
		}
		
	    @RequestMapping("/delete/{imge_id}")
	    public String delete(@PathVariable("imge_id") int imge_id) {
			    edu_website_imagesService.delete(imge_id);
			    return "redirect:/admin/imge/imagesPage";
		}
}
