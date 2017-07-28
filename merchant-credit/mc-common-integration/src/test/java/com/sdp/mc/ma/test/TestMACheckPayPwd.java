package com.sdp.mc.ma.test;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sdp.mc.common.enums.AccountType;
import com.sdp.mc.common.util.IPUtils;
import com.sdp.mc.common.vo.ErrorMessageVO;
import com.sdp.mc.integration.ma.dto.request.CheckPayPwdRequestDTO;
import com.sdp.mc.ma.wrapper.MaOnlineWrapper;
import com.sdp.mc.test.MCIntegrationBaseTest;

public class TestMACheckPayPwd extends MCIntegrationBaseTest {

	@Autowired
	private MaOnlineWrapper maOnlineWrapper;

	@Test
	public void testCheckPayPwd() {
		String memberId = "103100000000000045036041";//"203100000000000054888863";
		String accountId = this.maOnlineWrapper.queryAccount(memberId, IPUtils.getLocalIp(),AccountType.C_BASE_ACCOUNT);
		System.out.println("accountId================" + accountId);
		CheckPayPwdRequestDTO requestDTO = new CheckPayPwdRequestDTO();
		requestDTO.setAccountId(accountId);
		requestDTO.setPassword("1234qwer");
		requestDTO.setLoginName("18500000003");
		ErrorMessageVO em = this.maOnlineWrapper.checkPayPwd(requestDTO);
		System.out.println(ToStringBuilder.reflectionToString(em));
	}

}
