package com.huateng.reveice;

import java.util.List;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huateng.common.DataSource;
import com.huateng.dao.DeptDao;
import com.huateng.entity.Dept;
import com.huateng.service.DataSource1;
import com.huateng.service.DataSource2;
import com.rabbitmq.client.Channel;

@Service("receiveMessage")
public class ReceiveMessage implements ChannelAwareMessageListener{
	
	@Autowired
	DataSource1 dataSource1;
	@Autowired
	DataSource2 dataSource2;

	public void onMessage(Message message, Channel channel) throws Exception {
		try{
			System.err.println("**消息接收成功**:"+new String(message.getBody())+" :"+message.getMessageProperties());
			channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
			if(new String(message.getBody()).subSequence(0, 2) .equals("11")){
				dataSource1.selectDeptList();
			}else{
				dataSource2.selectDeptList();
			}
		}catch(Exception e){
			e.printStackTrace();
			//TODO 异常处理
			channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,false);
		}

		
	}

}
