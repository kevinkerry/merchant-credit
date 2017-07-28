package com.sdp.mc.fastsettle.thread.model;
import java.util.ArrayList;
import java.util.List;
import com.sdp.mc.integration.msp.MerchantInfoDTO;
import com.sdp.mc.integration.msp.PromoterInfoDTO;

/**
 * 开通T+0的代理商商户集合
 * @author heyi.alex
 *
 */
public class PrometerMerchantCalModel {

	@SuppressWarnings("unused")
	private PrometerMerchantCalModel(){}

	public PrometerMerchantCalModel(PromoterInfoDTO prometerInfoDTO ){this.prometerInfoDTO = prometerInfoDTO;}

	/**
	 * 代理商下的商户列表
	 */
	private List<MerchantInfoDTO> list = new ArrayList<MerchantInfoDTO>();

	private PromoterInfoDTO prometerInfoDTO = null;

	public void add(MerchantInfoDTO model){
		list.add(model);
	}

	public List<MerchantInfoDTO> getList() {
		return list;
	}

	public void setList(List<MerchantInfoDTO> list) {
		this.list = list;
	}

	public PromoterInfoDTO getPrometerInfoDTO() {
		return prometerInfoDTO;
	}

}
