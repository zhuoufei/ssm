package com.huateng.reveice;

import java.util.List;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huateng.dao.DeptDao;
import com.huateng.entity.Dept;
import com.rabbitmq.client.Channel;

@Service("receiveMessage")
public class ReceiveMessage implements ChannelAwareMessageListener{
	
	@Autowired
	DeptDao deptDao;
	
	public void onMessage(Message message, Channel channel) throws Exception {
		try{
			System.err.println("消息接收成功********:"+message.getMessageProperties()+":"+new String(message.getBody()));
			List<Dept> selectDeptList = deptDao.selectDeptList();
			for (Dept dept : selectDeptList) {
				System.out.println(dept.toString());
			}
			
			//channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
		}catch(Exception e){
			e.printStackTrace();//TODO 涓氬姟澶勭悊
			//channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,false);
		}
		
	}

}
