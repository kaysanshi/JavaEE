package com.leo.course.scheduling.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.boot.test.context.runner.ReactiveWebApplicationContextRunner;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leo.course.scheduling.domain.Classes;
import com.leo.course.scheduling.domain.Classroom;
import com.leo.course.scheduling.domain.Student;
import com.leo.course.scheduling.domain.Subject;
import com.leo.course.scheduling.domain.Teacher;
import com.leo.course.scheduling.domain.Times;
import com.leo.course.scheduling.service.ClassRoomService;
import com.leo.course.scheduling.service.ClassesService;
import com.leo.course.scheduling.service.CourseSchulingService;
import com.leo.course.scheduling.service.SubjectService;
import com.leo.course.scheduling.service.TeacherService;

import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;

/**
 * 排课
 * @author kay三石
 *TODO
 *2019年3月13日-下午7:30:39
 */
@Controller
@RequestMapping("/scheduling")
public class CourseSchedulingController {
	
	@Resource
	private CourseSchulingService csService;
	
	@Resource
	private SubjectService subjectService;//课程
	
	@Resource
	private TeacherService teacherService;//教师
	
	@Resource
	private ClassesService classesService;//班级
	
	@Resource
	private ClassRoomService classRoomService;//教室
	
	/**
	 * 依次得到学生，课程。教室，教师，
	 */
	private List<Student> list_student;//具体字段无用
	
	private List<Subject> list_subject;
	
	private List<Classes> list_class;
	
	private List<Times> list_times;
	private List<Classroom> list_room;
	
	private List<Teacher> list_teacher;
	private List<String> list_week;
	
	public List<String> getWeek() {
		list_week=new ArrayList<>();
		list_week.add("星期一");
		list_week.add("星期二");
		list_week.add("星期三");
		list_week.add("星期四");
		list_week.add("星期五");
		list_week.add("星期六");
		list_week.add("星期日");
		return list_week;	
	}
	
	/**
	 * 获得教师集合
	 * 获取到的集合还是有些问题，不能够过滤到其无用的
	 * @return
	 */
	public List<Teacher> getlistTeacher(){
		return teacherService.getListTeacherName();	
	}
	/**
	 * 获得课程集合
	 * @return
	 */
	public List<Subject> getListSubject(){
		return subjectService.getListSubjectName();
		
	}
	/**
	 * 获得班级集合
	 * @return
	 */
	public List<Classes> getListClassName(){
		return  classesService.getListClassesName();
	}
	/**
	 * 获得教室集合
	 * @return
	 */
	public List<Classroom> getListClassRoom(){
		
		return  classRoomService.getListClassesRoomName();
	}
	/**
	 * 获取学生集合
	 */
	public List<Student> getListStudentName(){
		return null;
	}
	/**
	 * 通过教师id来获取教师的信息
	 * @param teacherid
	 * @return
	 */
	public List<Teacher> getListTeacherById(List<Integer> teacherid){
		return teacherService.getListTeacherbyListId(teacherid);
		
	}
	/**
	 * 通过majorid来获取班级的信息
	 * @param list_majorno
	 * @return
	 */
	private List<Classes> getListClassById(List<String> list_majorno) {
		// TODO Auto-generated method stub
		return classesService.getListClassesById(list_majorno);
	}
	/**
	 * 去除集合中重复的元素
	 * @param list
	 * @return
	 */
	public List<String> removeRepetion(List<String> list){
		Set<String> set=new HashSet<>();
		List<String> newList=new ArrayList<>();
		for(String str:list) {
			if (set.add(str)) {
				newList.add(str);
			}
		}
		return newList;
	}
	/**
	 * 课程优先排列
	 * @return
	 */
	@RequestMapping("/bycourse")
	@ResponseBody
	public Map<String, Object> getSchedulingQuickByCourse(){
		Map<String, Object> map=new HashMap<>();
		list_teacher=this.getlistTeacher();
		list_class=this.getListClassName();
		list_room=this.getListClassRoom(); 
		//1.获得所得的课程
		list_subject=this.getListSubject();

		System.out.println("打印："+list_subject);
		//先通过课程优先排列，需要先遍历课程，分配相应的教师，然后分配相应的教室，及其时间段
		List<Integer> list_teacherid=new ArrayList<>();
		for(int i=0;i<list_subject.size();i++) {
			Integer teacherid=list_subject.get(i).getTeacherid();
			list_teacherid.add(teacherid);
		}
		//for (int i = 0; i < list_teacherid.size(); i++) {
		//	System.out.println(list_teacherid.get(i));
		//}
		//2.通过获得课程id来查询到这个教师，
		List<Teacher> list_teachers=this.getListTeacherById(list_teacherid);
		//获得major集合
		List<String> list_majorno=new ArrayList<>();
		for(int i=0;i<list_teachers.size();i++) {
			System.out.println(list_teachers.get(i));
			String majornoid=list_teachers.get(i).getMajor();
			list_majorno.add(majornoid);
		}
		List<String> newList_majorno=this.removeRepetion(list_majorno);
		for(String s: newList_majorno) {
			System.out.println(s);
		}
		//3.通过majorid来获取班级列表
		List<Classes> list_classes=this.getListClassById(newList_majorno);
		//直接输出到
		//System.out.println(list_classes.iterator());
		for(int i=0;i<list_classes.size();i++) {
			System.out.println(list_classes.get(i));
		}
		//把班级列表，和
		//通过得到的教师的
		return null;
		
	}
	

	/**
	 * 通过班级优先来排课
	 * @return
	 */
	@RequestMapping("/byclasses")
	@ResponseBody
	public Map<String, Object> getSchedulingQuickByClassName(){
		Map<String, Object> map=new HashMap<>();
		list_subject=this.getListSubject();
		list_teacher=this.getlistTeacher();
		list_class=this.getListClassName();
		list_room=this.getListClassRoom(); 
		System.out.println("打印："+list_subject);
		System.out.println(list_teacher);
		for(int i=0;i<list_class.size();i++) {
			
		}
		
		
		return null;
		
	}
	/**
	 * 班级优先排课
	 */
	@RequestMapping("")
	public Map<String, Object> getSchedulingQuickByClass(){
		Map<String, Object> map=new HashMap<>();
		
		
		return null;
		
	}
	
}
