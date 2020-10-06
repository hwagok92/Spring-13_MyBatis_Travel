package travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import travel.model.TravelDao;

@Controller
public class TravelDeleteController {
	final String command = "delete.tv";
	final String gotoPage = "redirect:/list.tv";

	@Autowired
	private TravelDao travelDao;

	@RequestMapping(command)
	public String doAction(@RequestParam("num") int num,
						@RequestParam("pageNumber") int pageNumber) {
		
		travelDao.deleteTravel(num);
		
		return gotoPage+"?pageNumber="+pageNumber;
	}
	
}