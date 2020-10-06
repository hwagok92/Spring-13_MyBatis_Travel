package travel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import travel.model.TravelBean;
import travel.model.TravelDao;

@Controller
public class TravelInsertController {
	final String command = "/insert.tv";
	final String getPage = "TravelInsertForm";
	final String gotoPage = "redirect:/list.tv";

	// /WEB-INF/travel/travelInsertForm.jsp

	@Autowired
	private TravelDao travelDao;

	@RequestMapping(value = command, method = RequestMethod.GET)
	public String doAction() {
		return getPage;
	}

	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView doAction(@ModelAttribute("tb") @Valid TravelBean travel, BindingResult result) {

		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			System.out.println("유효성 검사 오류입니다.");
			mav.setViewName(getPage);
			return mav;
		}
		int cnt = travelDao.insertTravel(travel);
		System.out.println("insert cnt:" + cnt);
		mav.setViewName(gotoPage);
		return mav;
	}

}
