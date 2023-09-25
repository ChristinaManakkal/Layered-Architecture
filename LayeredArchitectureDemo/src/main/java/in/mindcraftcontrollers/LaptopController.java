package in.mindcraftcontrollers;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import in.mindcraft.dao.LaptopDao;
import in.mindcraft.pojos.Laptop;

@Controller
public class LaptopController {
	
	private LaptopDao laptopDao=new LaptopDao(); //object of dao class
	
	
	@RequestMapping("/insertlap")
	public void addLaptop(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException {
		int lid=Integer.parseInt(request.getParameter("lid"));
		String make=request.getParameter("make");
		double cost=Double.parseDouble(request.getParameter("cost"));
		
		Laptop laptop= new Laptop(lid,make,cost);
		
		laptopDao.addLaptop(laptop);
	}
	
	@RequestMapping("/showlaps")
	public ModelAndView showLaptops() throws ClassNotFoundException {
		ModelAndView mv=new ModelAndView();
		try {
			List<Laptop> list=laptopDao.getLaptops();
			System.out.println(list);
			mv.setViewName("result.jsp");
			mv.addObject("list",list);
			
		}catch(SQLException e) {
			
		}
		return mv;
	}
	
}
