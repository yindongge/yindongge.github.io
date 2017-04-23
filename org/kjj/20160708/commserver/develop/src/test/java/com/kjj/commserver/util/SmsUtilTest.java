package com.kjj.commserver.util;

import org.junit.Test;

public class SmsUtilTest {

	@Test
	public void testSendVerificationMessage() {
		SmsUtil.sendVerificationMessage("15210301372", "123456");
	}
	
	@Test
	public void testSendTakeCodeMessage() {
		SmsUtil.sendTakeCodeMessage("15210301372", "123456", "1200000000");
	}

}
