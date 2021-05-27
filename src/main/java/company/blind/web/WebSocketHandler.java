package company.blind.web;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.ui.Model;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebSocketHandler extends TextWebSocketHandler {
	
	// 클라이언트 최초 웹소켓 요청시 생성
	private Set<WebSocketSession> sessions = Collections.synchronizedSet(new HashSet<WebSocketSession>());
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// 메세지 처리부
		System.out.printf("%s 로부터 [%s]받음", session.getId(), message.getPayload());
		System.out.println();
		session.sendMessage(new TextMessage(message.getPayload()));
	}
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// 연결 요청 접수 -> 해당 클라이언트와 통신을 담당하는 WebSocketSession 객체 전달
		// WebSocketSession 객체를 Set에 담아둠
		System.out.printf("%s 연결됨", session.getId());
		System.out.println();
		sessions.add(session);
	}
	
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		// 클라이언트와 데이터 송수신중 에러가 발생시 통신담당 객체를 HashSet에서 제거
		sessions.remove(session);
	}
}
