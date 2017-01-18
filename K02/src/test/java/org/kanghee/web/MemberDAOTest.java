package org.kanghee.web;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kanghee.domain.Criteria;
import org.kanghee.domain.MemberVO;
import org.kanghee.domain.SearchCriteria;
import org.kanghee.persistence.MemberDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class MemberDAOTest {

	@Autowired
	private MemberDAOImpl dao;
	
	@Test
	public void createTest() throws Exception {
		
		MemberVO vo = new MemberVO();
		
		vo.setUid("user00" );
		vo.setUpw("user00" );
		vo.setEmail("aaa@bbb.com");
		vo.setUname("user00");
		vo.setUimg("a.jpg");
		
		dao.create(vo);
		System.out.println(vo);
	}
	
	@Test
	public void readTest() throws Exception {
		Integer uno = 1;
		System.out.println(dao.read(uno));
	}
	
	@Test
	public void updateTest() throws Exception {
		MemberVO vo = new MemberVO();
		
		vo.setUid("user01");
		vo.setUpw("user01");
		vo.setEmail("bbb@ccc.com");
		vo.setUname("user01");
		vo.setUimg("1.jpg");
		vo.setUno(13);
		
		dao.update(vo);
		System.out.println(vo);
	}
	
	@Test
	public void deleteTest() throws Exception {
		Integer uno = 12;
		dao.delete(uno);
		System.out.println(uno);
	}

	@Test
	public void listTest() throws Exception {
		System.out.println(dao.list());
	}
	
	@Test
	public void listPageTest() throws Exception {
		
		int page = 1;
		
		List<MemberVO> list = dao.listPage(page);
		
		for (MemberVO memberVO : list) {
			System.out.println(memberVO.getUno() + ":" + memberVO.getUid() + ":" + memberVO.getUpw()
			+ ":" + memberVO.getUname() + ":" + memberVO.getEmail() + ":" + memberVO.getUimg());
		}
	}
	
	@Test
	public void listCriteriaTest() throws Exception {
		
		Criteria cri = new Criteria();
		
		cri.setPage(1);
		cri.setPerPageNum(20);
		
		List<MemberVO> list = dao.listCriteria(cri);
		
		for (MemberVO memberVO : list) {
			System.out.println(memberVO.getUno() + ":" + memberVO.getUid() + ":" + memberVO.getUpw()
			+ ":" + memberVO.getUname() + ":" + memberVO.getEmail() + ":" + memberVO.getUimg());
		}
	}
	
	@Test
	public void testDynamic1() throws Exception {
		
		SearchCriteria cri = new SearchCriteria();
		cri.setPage(1);
		cri.setKeyword("car08");
		cri.setSearchType("i");
		
		System.out.println("===============================");
		
		List<MemberVO> list = dao.listSearch(cri);
		
		for (MemberVO memberVO : list) {
			System.out.println(memberVO.getUno() + ":" + memberVO.getUid() + ":" + memberVO.getUpw()
			+ ":" + memberVO.getUname() + ":" + memberVO.getEmail() + ":" + memberVO.getUimg());
		}
		
		System.out.println("================================");
		System.out.println("COUNT: " + dao.listSearchCount(cri));
	}
}
