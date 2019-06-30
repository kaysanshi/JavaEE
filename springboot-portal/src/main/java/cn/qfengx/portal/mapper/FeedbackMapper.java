package cn.qfengx.portal.mapper;

import java.util.List;

import cn.qfengx.portal.bean.Feedback;
import cn.qfengx.portal.bean.FeedbackQueryVo;

public interface FeedbackMapper {

	public void delete(Integer[] ids);

	public int add(Feedback feedback);

	public List<Feedback> query(FeedbackQueryVo fdvo);

	public int querySum(FeedbackQueryVo fdvo);

}
