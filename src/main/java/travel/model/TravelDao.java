package travel.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component("myTravelDao")
public class TravelDao {
	
	@Autowired //객체를 아래 변수에 넣어라, (객체는 root-context.xml에서 만들었다)
	SqlSessionTemplate sqlSessionTemplate;
	
	public int insertTravel(TravelBean travel) {
		int cnt = sqlSessionTemplate.insert("travel.TravelBean.InsertTravel",travel);
		System.out.println("insertTravel cnt"+cnt);
		return cnt;
	}
	
	public List<TravelBean> getTravelList(Paging pageInfo, Map<String, String> map){
		List<TravelBean> lists = new ArrayList<TravelBean>();
		RowBounds rowbounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		lists = sqlSessionTemplate.selectList("travel.TravelBean.GetTravelList",map,rowbounds);
		
		return lists;
	}
	
	public int getTotalCount(Map<String,String> map) {
		int cnt = sqlSessionTemplate.selectOne("travel.TravelBean.GetTotalCount", map);
		return cnt;
	}
	
	public int deleteTravel(int num) {
		int cnt = sqlSessionTemplate.delete("travel.TravelBean.DeleteTravel",num);
		return cnt;
	}
	
	public TravelBean getOneTravel(int num) {
		TravelBean travel = sqlSessionTemplate.selectOne("travel.TravelBean.GetOneTravel",num);
		return travel;
	}
	
	public int UpdateTravel(TravelBean travel) {
		int cnt = sqlSessionTemplate.update("travel.TravelBean.UpdateTravel",travel);
		return cnt;
	}
	
}
