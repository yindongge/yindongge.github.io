package com.kjj.commserver.service.report.impl;

import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.stereotype.Service;

import com.kjj.commserver.constant.FileConstant;
import com.kjj.commserver.entity.order.OrgOrder;
import com.kjj.commserver.entity.order.OrgOrderGoods;
import com.kjj.commserver.entity.order.OrgRefundOrder;
import com.kjj.commserver.entity.order.aide.OrgOrderGoodsOrderReportVo;
import com.kjj.commserver.entity.order.aide.OrgOrderGoodsQuery;
import com.kjj.commserver.entity.order.aide.OrgOrderGoodsVo;
import com.kjj.commserver.entity.order.aide.OrgOrderQuery;
import com.kjj.commserver.entity.order.aide.OrgOrderVo;
import com.kjj.commserver.entity.order.aide.OrgRefundOrderQuery;
import com.kjj.commserver.entity.order.aide.OrgRefundOrderVo;
import com.kjj.commserver.entity.report.aide.OrgOrderReportQuery;
import com.kjj.commserver.service.goods.OrgProductLinkSalespecService;
import com.kjj.commserver.service.order.OrgOrderGoodsService;
import com.kjj.commserver.service.order.OrgOrderService;
import com.kjj.commserver.service.order.OrgRefundOrderService;
import com.kjj.commserver.service.report.OrgOrderReportService;
import com.kjj.commserver.util.DateFormatUtil;

@Service
public class OrgOrderReportServiceImpl implements OrgOrderReportService{
	
	@Resource
	private OrgOrderGoodsService orgOrderGoodsService;
	
	@Resource
	private OrgOrderService orgOrderService;
	
	@Resource
	private OrgRefundOrderService orgRefundOrderService;
	
	@Resource
	private OrgProductLinkSalespecService orgProductLinkSalespecService;

	@Override
	public String exportOrderExcel(OrgOrderReportQuery query) {
		
		OrgOrderGoodsQuery orderGoodsQuery = new OrgOrderGoodsQuery();
		orderGoodsQuery.setCreateTimeStart(query.getCreateTimeStart());
		orderGoodsQuery.setCreateTimeEnd(query.getCreateTimeEnd());
		List<OrgOrderGoods> listOrderGoods = orgOrderGoodsService.queryList4OrderReport(orderGoodsQuery);
		HSSFWorkbook workbook = new HSSFWorkbook();
		//sheet1 按商品
		HSSFSheet sheet = workbook.createSheet("按商品");
		HSSFCellStyle style = workbook.createCellStyle();
		
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平
		
		//创建保留两位小数的样式
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
		
		//创建表头
		HSSFRow rowHead = sheet.createRow(0);
		String[] heads = {"订单编号","会员名","店铺","下单时间","支付时间","商品名称","商品属性","原价","折扣价","购买数量","订单状态","所在地区","收货地址","收货人姓名","手机号","邮箱","附言","来源"};
		for (int i = 0; i < heads.length; i++) {			
			HSSFCell cell = rowHead.createCell(i);
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell.setCellValue(heads[i]);
		}
		//添加数据
		if (listOrderGoods.size() > 0) {
			OrgOrderGoodsOrderReportVo orgOrderGoodsOrderReportVo = null;
			for (int i = 0; i < listOrderGoods.size(); i++) {
				orgOrderGoodsOrderReportVo = (OrgOrderGoodsOrderReportVo) listOrderGoods.get(i);
				HSSFRow rowData = sheet.createRow(i + 1);

				HSSFCell cell = rowData.createCell(0);
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell.setCellValue(orgOrderGoodsOrderReportVo.getOrderId().toString());

				HSSFCell cell1 = rowData.createCell(1);
				cell1.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell1.setCellValue(orgOrderGoodsOrderReportVo.getUserName());

				HSSFCell cell2 = rowData.createCell(2);
				cell2.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell2.setCellValue(orgOrderGoodsOrderReportVo.getShopName());

				HSSFCell cell3 = rowData.createCell(3);
				cell3.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell3.setCellValue(DateFormatUtil.formatDateTime(orgOrderGoodsOrderReportVo.getOrgOrder().getCreateTime()));

				HSSFCell cell4 = rowData.createCell(4);
				cell4.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell4.setCellValue(DateFormatUtil.formatDateTime(orgOrderGoodsOrderReportVo.getOrgOrder().getPayTime()));

				HSSFCell cell5 = rowData.createCell(5);
				cell5.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell5.setCellValue(orgOrderGoodsOrderReportVo.getOrgProductItem().getGoodsName());

				HSSFCell cell6 = rowData.createCell(6);
				cell6.setCellType(HSSFCell.CELL_TYPE_STRING);
				// TODO 
				cell6.setCellValue("");

				HSSFCell cell7 = rowData.createCell(7);
				cell7.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell7.setCellStyle(cellStyle);
				cell7.setCellValue(orgOrderGoodsOrderReportVo.getUnitAccounts().doubleValue());

				HSSFCell cell8 = rowData.createCell(8);
				cell8.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell8.setCellStyle(cellStyle);
				cell8.setCellValue(orgOrderGoodsOrderReportVo.getUnitPrice().doubleValue());

				HSSFCell cell9 = rowData.createCell(9);
				cell9.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell9.setCellValue(orgOrderGoodsOrderReportVo.getAmount());

				HSSFCell cell10 = rowData.createCell(10);
				cell10.setCellType(HSSFCell.CELL_TYPE_STRING);
				switch (orgOrderGoodsOrderReportVo.getOrgOrder().getStatus()) {
				case 0:
					cell10.setCellValue("待付款");
					break;
				case 1:
					cell10.setCellValue("待确认");
					break;
				case 2:
					if(orgOrderGoodsOrderReportVo.getOrgOrder().getSendStyle() == 0){
						cell10.setCellValue("待发货");
						break;
					}
						cell10.setCellValue("备货中");
						break;
				case 3:
					if(orgOrderGoodsOrderReportVo.getOrgOrder().getSendStyle() == 0){
						cell10.setCellValue("待收货");
						break;
					}
						cell10.setCellValue("待自提");
						break;
				case 4:
					cell10.setCellValue("已完成");
					break;
				case 5:
					cell10.setCellValue("已取消");
					break;
				case 6:
					cell10.setCellValue("已关闭");
					break;
				default:
					cell10.setCellValue("");
					break;
				}
				HSSFCell cell11 = rowData.createCell(11);
				cell11.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell11.setCellValue(orgOrderGoodsOrderReportVo.getShow());

				HSSFCell cell12 = rowData.createCell(12);
				cell12.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell12.setCellValue(orgOrderGoodsOrderReportVo.getOrgOrder().getConsigneeAddress());

				HSSFCell cell13 = rowData.createCell(13);
				cell13.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell13.setCellValue(orgOrderGoodsOrderReportVo.getOrgOrder().getConsignee());

				HSSFCell cell14 = rowData.createCell(14);
				cell14.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell14.setCellValue(orgOrderGoodsOrderReportVo.getOrgOrder().getConsigneeMobile());

				HSSFCell cell15 = rowData.createCell(15);
				cell15.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell15.setCellValue(orgOrderGoodsOrderReportVo.getOrgOrder().getConsigneeEmail());

				HSSFCell cell16 = rowData.createCell(16);
				cell16.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell16.setCellValue(orgOrderGoodsOrderReportVo.getOrgOrder().getRemark());

				HSSFCell cell17 = rowData.createCell(17);
				cell17.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell17.setCellValue(orgOrderGoodsOrderReportVo.getOrgOrder().getSource());
				switch (orgOrderGoodsOrderReportVo.getOrgOrder().getSource()) {
				case 1:
					cell17.setCellValue("PC");
					break;
				case 2:
					cell17.setCellValue("触摸屏");
					break;
				default:
					cell17.setCellValue("");
					break;
				}
			}

		}
		
		// sheet2按订单
		HSSFSheet sheet2 = workbook.createSheet("按订单");
		// 创建表头
		HSSFRow rowHead2 = sheet2.createRow(0);
		String[] heads2 = { "订单编号", "会员名/手机号", "店铺", "配送方式", "支付方式", "下单时间",
				"支付时间", "商品", "规格", "价格", "折扣价", "数量", "订单优惠", "订单金额", "预付费付款", "实付金额", "订单状态",
				"所在地区", "详细地址", "收货人", "手机号", "邮箱", "发票", "来源", "支付状态" };
		for (int i = 0; i < heads2.length; i++) {
			HSSFCell cell = rowHead2.createCell(i);
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell.setCellStyle(style);
			cell.setCellValue(heads2[i]);
		}
		
		OrgOrderQuery orgOrderQuery = new OrgOrderQuery();
		orgOrderQuery.setCreateTimeStart(query.getCreateTimeStart());
		orgOrderQuery.setCreateTimeEnd(query.getCreateTimeEnd());
		List<OrgOrder> orderList =  orgOrderService.queryList4Report(orgOrderQuery);
		
		int rowNum=1;
		// 创建数据
		if (orderList.size() > 0) {
			OrgOrderVo orgOrderVo = null;
			for (int i = 0; i < orderList.size(); i++) {
				orgOrderVo = (OrgOrderVo) orderList.get(i);
				listOrderGoods = orgOrderVo.getListOrderGoods();
				
				sheet2.addMergedRegion(new CellRangeAddress(rowNum, rowNum+listOrderGoods.size()-1, 0, 0));
				HSSFRow rowData = sheet2.createRow(rowNum);
				HSSFCell cell0 = rowData.createCell(0);
				cell0.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell0.setCellStyle(style);
				cell0.setCellValue(orgOrderVo.getOrderId().toString());

				sheet2.addMergedRegion(new CellRangeAddress(rowNum, rowNum+listOrderGoods.size()-1, 1, 1));
				HSSFCell cell1 = rowData.createCell(1);
				cell1.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell1.setCellStyle(style);
				cell1.setCellValue(orgOrderVo.getUserName() != null ? orgOrderVo.getUserName(): ""+ "//"+ orgOrderVo.getConsigneeMobile() != null ? orgOrderVo.getConsigneeMobile() : "");
				
				sheet2.addMergedRegion(new CellRangeAddress(rowNum, rowNum+listOrderGoods.size()-1, 2, 2));
				HSSFCell cell2 = rowData.createCell(2);
				cell2.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell2.setCellStyle(style);
				cell2.setCellValue(orgOrderVo.getOrgShop().getShopName());

				sheet2.addMergedRegion(new CellRangeAddress(rowNum, rowNum+listOrderGoods.size()-1, 3, 3));
				HSSFCell cell3 = rowData.createCell(3);
				cell3.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell3.setCellStyle(style);
				switch (orgOrderVo.getSendStyle()) {
				case 0:
					cell3.setCellValue("送货上门 ");
					break;
				case 1:
					cell3.setCellValue("到店自取");
					break;
				default:
					cell3.setCellValue("");
					break;
				}

				sheet2.addMergedRegion(new CellRangeAddress(rowNum, rowNum+listOrderGoods.size()-1, 4, 4));
				HSSFCell cell4 = rowData.createCell(4);
				cell4.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell4.setCellStyle(style);
				String payStyle = "";
				if(orgOrderVo.getDepositMoney().compareTo(BigDecimal.ZERO) > 0){
					payStyle += "预";
					if((orgOrderVo.getOnlinePayStyle() != null && orgOrderVo.getOnlinePayStyle() > 0 )
							|| (orgOrderVo.getLocalPayStyle() != null && orgOrderVo.getLocalPayStyle() > 0 )){
						payStyle += "+";
					}
				}else if((orgOrderVo.getOnlinePayStyle() != null && orgOrderVo.getOnlinePayStyle() == 0 )
						|| (orgOrderVo.getLocalPayStyle() != null && orgOrderVo.getLocalPayStyle() == 0 )){
					payStyle += "无需付款";
				}
				
				if (orgOrderVo.getPayStyle() == 0 && orgOrderVo.getOnlinePayStyle() != null) {
					switch (orgOrderVo.getOnlinePayStyle()) {
					case 1:
						payStyle += "支";
						break;
					case 2:
						payStyle += "微信";
						break;
					case 3:
						payStyle += "财";
						break;
					case 4:
						payStyle += "银联";
						break;
					case 5:
						payStyle += "微信";
						break;
					case 6:
						payStyle += "支";
						break;
					default:
						break;
					}
				}else if(orgOrderVo.getPayStyle() == 1){
					if(orgOrderVo.getLocalPayStyle() == 1){
						payStyle += "现金";
					}else if(orgOrderVo.getLocalPayStyle() == 2){
						payStyle += "POS";
					}
				}
				cell4.setCellValue(payStyle);
				
				sheet2.addMergedRegion(new CellRangeAddress(rowNum, rowNum+listOrderGoods.size()-1, 5, 5));
				HSSFCell cell5 = rowData.createCell(5);
				cell5.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell5.setCellStyle(style);
				cell5.setCellValue(DateFormatUtil.formatDateTime(orgOrderVo.getCreateTime()));

				sheet2.addMergedRegion(new CellRangeAddress(rowNum, rowNum+listOrderGoods.size()-1, 6, 6));
				HSSFCell cell6 = rowData.createCell(6);
				cell6.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell6.setCellStyle(style);
				cell6.setCellValue(DateFormatUtil.formatDateTime(orgOrderVo.getPayTime()));
				
				OrgOrderGoodsVo orgOrderGoodsVo = null;
				for (int j = 0; j < listOrderGoods.size(); j++) {
					orgOrderGoodsVo = (OrgOrderGoodsVo) listOrderGoods.get(j);
					if (j == 0) {
						HSSFCell cell7 = rowData.createCell(7);
						cell7.setCellType(HSSFCell.CELL_TYPE_STRING);
						cell7.setCellStyle(style);
						cell7.setCellValue(null == orgOrderGoodsVo.getOrgProductItem().getGoodsName() ? "":orgOrderGoodsVo.getOrgProductItem().getGoodsName());

						HSSFCell cell8 = rowData.createCell(8);
						cell8.setCellType(HSSFCell.CELL_TYPE_STRING);
						cell8.setCellStyle(style);
						// TODO
						cell8.setCellValue("");

						HSSFCell cell9 = rowData.createCell(9);
						cell9.setCellType(HSSFCell.CELL_TYPE_STRING);
						cell9.setCellStyle(cellStyle);
						cell9.setCellValue(orgOrderGoodsVo.getUnitAccounts().doubleValue());

						HSSFCell cell10 = rowData.createCell(10);
						cell10.setCellType(HSSFCell.CELL_TYPE_STRING);
						cell10.setCellStyle(cellStyle);
						cell10.setCellValue(orgOrderGoodsVo.getUnitPrice().doubleValue());

						HSSFCell cell11 = rowData.createCell(11);
						cell11.setCellType(HSSFCell.CELL_TYPE_STRING);
						cell11.setCellValue(orgOrderGoodsVo.getAmount());

					} else {
						HSSFRow rowGoodsData = sheet2.createRow(rowNum + j);

						HSSFCell cell7 = rowGoodsData.createCell(7);
						cell7.setCellType(HSSFCell.CELL_TYPE_STRING);
						cell7.setCellStyle(style);
						cell7.setCellValue(null == orgOrderGoodsVo.getOrgProductItem().getGoodsName() ? "":orgOrderGoodsVo.getOrgProductItem().getGoodsName());

						HSSFCell cell8 = rowGoodsData.createCell(8);
						cell8.setCellType(HSSFCell.CELL_TYPE_STRING);
						cell8.setCellStyle(style);
						// TODO
						cell8.setCellValue("");

						HSSFCell cell9 = rowGoodsData.createCell(9);
						cell9.setCellType(HSSFCell.CELL_TYPE_STRING);
						cell9.setCellStyle(cellStyle);
						cell9.setCellValue(orgOrderGoodsVo.getUnitAccounts().doubleValue());

						HSSFCell cell10 = rowGoodsData.createCell(10);
						cell10.setCellType(HSSFCell.CELL_TYPE_STRING);
						cell10.setCellStyle(cellStyle);
						cell10.setCellValue(orgOrderGoodsVo.getUnitPrice().doubleValue());

						HSSFCell cell11 = rowGoodsData.createCell(11);
						cell11.setCellType(HSSFCell.CELL_TYPE_STRING);
						cell11.setCellValue(orgOrderGoodsVo.getAmount());
					}

				}

				sheet2.addMergedRegion(new CellRangeAddress(rowNum, rowNum+listOrderGoods.size()-1, 12, 12));
				HSSFCell cell12 = rowData.createCell(12);
				cell12.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell12.setCellStyle(cellStyle);
				cell12.setCellValue(orgOrderVo.getDiscount().doubleValue());

				sheet2.addMergedRegion(new CellRangeAddress(rowNum, rowNum+listOrderGoods.size()-1, 13, 13));
				HSSFCell cell13 = rowData.createCell(13);
				cell13.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell13.setCellStyle(cellStyle);
				cell13.setCellValue(orgOrderVo.getOrderMoney().doubleValue());
				
				sheet2.addMergedRegion(new CellRangeAddress(rowNum, rowNum+listOrderGoods.size()-1, 14, 14));
				HSSFCell cell14 = rowData.createCell(14);
				cell14.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell14.setCellStyle(cellStyle);
				cell14.setCellValue(orgOrderVo.getDepositMoney().doubleValue());
				
				sheet2.addMergedRegion(new CellRangeAddress(rowNum, rowNum+listOrderGoods.size()-1, 15, 15));
				HSSFCell cell15 = rowData.createCell(15);
				cell15.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell15.setCellStyle(cellStyle);
				cell15.setCellValue(orgOrderVo.getPayMoney().doubleValue());

				sheet2.addMergedRegion(new CellRangeAddress(rowNum, rowNum+listOrderGoods.size()-1, 16, 16));
				HSSFCell cell16 = rowData.createCell(16);
				cell16.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell16.setCellStyle(style);
				switch (orgOrderVo.getStatus()) {
				case 0:
					cell16.setCellValue("待付款");
					break;
				case 1:
					cell16.setCellValue("待确认");
					break;
				case 2:
					if(orgOrderVo.getSendStyle() == 0){
						cell16.setCellValue("待发货");
						break;
					}
						cell16.setCellValue("备货中");
						break;
				case 3:
					if(orgOrderVo.getSendStyle() == 0){
						cell16.setCellValue("待收货");
						break;
					}
						cell16.setCellValue("待自提");
						break;
				case 4:
					cell16.setCellValue("已完成");
					break;
				case 5:
					cell16.setCellValue("已取消");
					break;
				case 6:
					cell16.setCellValue("已关闭");
					break;
				default:
					cell16.setCellValue("");
					break;

				}

				sheet2.addMergedRegion(new CellRangeAddress(rowNum, rowNum+listOrderGoods.size()-1, 17, 17));
				HSSFCell cell17 = rowData.createCell(17);
				cell17.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell17.setCellStyle(style);
				cell17.setCellValue(orgOrderVo.getShow());

				sheet2.addMergedRegion(new CellRangeAddress(rowNum, rowNum+listOrderGoods.size()-1, 18, 18));
				HSSFCell cell18 = rowData.createCell(18);
				cell18.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell18.setCellStyle(style);
				cell18.setCellValue(orgOrderVo.getConsigneeAddress());

				sheet2.addMergedRegion(new CellRangeAddress(rowNum, rowNum+listOrderGoods.size()-1, 19, 19));
				HSSFCell cell19 = rowData.createCell(19);
				cell19.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell19.setCellStyle(style);
				cell19.setCellValue(orgOrderVo.getConsignee());

				sheet2.addMergedRegion(new CellRangeAddress(rowNum, rowNum+listOrderGoods.size()-1, 20, 20));
				HSSFCell cell20 = rowData.createCell(20);
				cell20.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell20.setCellStyle(style);
				cell20.setCellValue(orgOrderVo.getConsigneeMobile());

				sheet2.addMergedRegion(new CellRangeAddress(rowNum, rowNum+listOrderGoods.size()-1, 21, 21));
				HSSFCell cell21 = rowData.createCell(21);
				cell21.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell21.setCellStyle(style);
				cell21.setCellValue(orgOrderVo.getConsigneeEmail());

				sheet2.addMergedRegion(new CellRangeAddress(rowNum, rowNum+listOrderGoods.size()-1, 22, 22));
				HSSFCell cell22 = rowData.createCell(22);
				cell22.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell22.setCellStyle(style);
				cell22.setCellValue(orgOrderVo.getInvoice());

				sheet2.addMergedRegion(new CellRangeAddress(rowNum, rowNum+listOrderGoods.size()-1, 23, 23));
				HSSFCell cell23 = rowData.createCell(23);
				cell23.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell23.setCellStyle(style);
				switch (orgOrderVo.getSource()) {
				case 1:
					cell23.setCellValue("pc");
					break;
				case 2:
					cell23.setCellValue("触摸屏");
					break;
				default:
					cell23.setCellValue("");
					break;
				}

				sheet2.addMergedRegion(new CellRangeAddress(rowNum, rowNum+listOrderGoods.size()-1, 24, 24));
				HSSFCell cell24 = rowData.createCell(24);
				cell24.setCellType(HSSFCell.CELL_TYPE_STRING);
				cell24.setCellStyle(style);
				switch (orgOrderVo.getPayStatus()) {
				case 0:
					cell24.setCellValue("未支付");
					break;
				case 1:
					cell24.setCellValue("已支付");
					break;
				default:
					cell24.setCellValue("");
					break;
				}
				
				rowNum +=listOrderGoods.size();
			}
		}
		 
		//sheet3退款单
		OrgRefundOrderQuery orgRefundOrderQuery = new OrgRefundOrderQuery();
		orgRefundOrderQuery.setCreateTimeStart(query.getCreateTimeStart());
		orgRefundOrderQuery.setCreateTimeEnd(query.getCreateTimeEnd());
		List<OrgRefundOrder> refundOrderList =  orgRefundOrderService.queryList(orgRefundOrderQuery);
		
		HSSFSheet sheet3 = workbook.createSheet("退款单");
		//创建表头
		HSSFRow rowHead3 = sheet3.createRow(0);
		String[] heads3 = {"退款单号","订单号","退货单号","会员名","退款方式","在线退款方式","退款状态","退款金额","创建时间","退款操作人","退款时间"};
		
		for (int i = 0; i < heads3.length; i++) {
			HSSFCell cell = rowHead3.createCell(i);
			cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell.setCellStyle(style);
			cell.setCellValue(heads3[i]);
		}
		
		OrgRefundOrder orgRefundOrder = null;
		OrgRefundOrderVo orgRefundOrderVo = null;
		for (int i = 0; i < refundOrderList.size(); i++) {
			orgRefundOrder =  refundOrderList.get(i);
			orgRefundOrderVo =  (OrgRefundOrderVo)refundOrderList.get(i);
			HSSFRow rowData = sheet3.createRow(i+1);
			
		    HSSFCell cell0= rowData.createCell(0);
		    cell0.setCellType(HSSFCell.CELL_TYPE_STRING);
		    cell0.setCellStyle(style);
		    cell0.setCellValue(orgRefundOrder.getRefundOrderId().toString());
		    
		    HSSFCell cell1 = rowData.createCell(1);
		    cell1.setCellType(HSSFCell.CELL_TYPE_STRING);
		    cell1.setCellStyle(style);
		    cell1.setCellValue(orgRefundOrder.getOrderId().toString());
		    
		    HSSFCell cell2 = rowData.createCell(2);
		    cell2.setCellType(HSSFCell.CELL_TYPE_STRING);
		    cell2.setCellStyle(style);
		    cell2.setCellValue(null != orgRefundOrder.getReturnOrderId() ? orgRefundOrder.getReturnOrderId().toString() :"" );
		    
		    HSSFCell cell3 = rowData.createCell(3);
		    cell3.setCellType(HSSFCell.CELL_TYPE_STRING);
		    cell3.setCellStyle(style);
		    cell3.setCellValue(orgRefundOrderVo.getUserName());
		    
		    HSSFCell cell4 = rowData.createCell(4);
		    cell4.setCellType(HSSFCell.CELL_TYPE_STRING);
		    cell4.setCellStyle(style);
		    switch(orgRefundOrder.getRefundStyle()){
		    case 0:
		    	cell4.setCellValue("在线");
		    	break;
		    case 1:
		    	cell4.setCellValue("本地");
		    	break;
		    case 2:
		    	cell4.setCellValue("预");
		    	break;
		    default:
		    	cell4.setCellValue("");
		    	break;
		    }
		    
		    HSSFCell cell5 = rowData.createCell(5);
		    cell5.setCellType(HSSFCell.CELL_TYPE_STRING);
		    cell5.setCellStyle(style);
		    if(null != orgRefundOrder.getOnlineRefundStyle()){
		    	switch(orgRefundOrder.getOnlineRefundStyle()){
		    	case 1:
		    		cell5.setCellValue("支");
		    		break;
		    	case 2:
		    		cell5.setCellValue("微信");
		    		break;
		    	case 3:
		    		cell5.setCellValue("财");
		    		break;
		    	case 4:
		    		cell5.setCellValue("银联");
		    		break;
		    	case 5:
		    		cell5.setCellValue("微信");
		    		break;
		    	case 6:
		    		cell5.setCellValue("支");
		    		break;
		    	default: 
		    		cell5.setCellValue("");
		    		break;
		    	}
		    }
		    
		    HSSFCell cell6 = rowData.createCell(6);
		    cell6.setCellType(HSSFCell.CELL_TYPE_STRING);
		    cell6.setCellStyle(style);
		    switch(orgRefundOrder.getRefundStatus()){
		    case 0:
		    	cell6.setCellValue("退款中");
		    	break;
		    case 1:
		    	cell6.setCellValue("退款完成");
		    	break;
		    default:
		   		cell6.setCellValue("");
		   		break;
		    }
		    
		    HSSFCell cell7 = rowData.createCell(7);
		    cell7.setCellType(HSSFCell.CELL_TYPE_STRING);
		    cell7.setCellStyle(cellStyle);
		    cell7.setCellValue(orgRefundOrder.getRefundMoney().doubleValue());
		    
		    HSSFCell cell8 = rowData.createCell(8);
		    cell8.setCellType(HSSFCell.CELL_TYPE_STRING);
		    cell8.setCellStyle(style);
	    	cell8.setCellValue(DateFormatUtil.formatDateTime(orgRefundOrder.getCreateTime()));
		    
		    HSSFCell cell9 = rowData.createCell(9);
		    cell9.setCellType(HSSFCell.CELL_TYPE_STRING);
		    cell9.setCellStyle(style);
		    cell9.setCellValue(StringUtils.isBlank(orgRefundOrderVo.getAdminName()) ? "系统" : orgRefundOrderVo.getAdminName());
		    
		    HSSFCell cell10 = rowData.createCell(10);
		    cell10.setCellType(HSSFCell.CELL_TYPE_STRING);
		    cell10.setCellStyle(style);
	    	cell10.setCellValue(DateFormatUtil.formatDateTime(orgRefundOrder.getRefundTime()));
		}
		
		String fileName = DateFormatUtil.formatDateTime( orderGoodsQuery.getCreateTimeStart()) + "至" + DateFormatUtil.formatDateTime(orderGoodsQuery.getCreateTimeEnd()) + "订单统计"+"_" + System.currentTimeMillis() + ".xls";
		fileName = fileName.replaceAll(" ", "").replaceAll(":", "");
		try {	
			FileOutputStream fileOutputStream = new FileOutputStream(FileConstant.FILE_BASE_PATH + FileConstant.ORDER_REPORT + fileName);
			workbook.write(fileOutputStream);
			fileOutputStream.close();
			workbook.close();
		} catch (Exception e) {
		}
		return FileConstant.FILE_BASE_URL + FileConstant.ORDER_REPORT + fileName;
	}
}