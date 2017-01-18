package org.kanghee.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kanghee.domain.ReplyVO;
import org.kanghee.persistence.ReplyDAO;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class ReplyDAOTest {

	@Inject
	private ReplyDAO dao;
	
	@Test
	public void replyCreateTest() throws Exception {
		
		ReplyVO vo = new ReplyVO();
		vo.setUno(16);
		vo.setReplyer("user02");
		vo.setReplytext("JJANG");
		
		dao.create(vo);
		
		System.out.println(vo);		
	}
	
	@Test
	public void replyDeleteTest() throws Exception {
		
		Integer rno = 3;
		dao.delete(rno);
		System.out.println(rno);
	}
}
