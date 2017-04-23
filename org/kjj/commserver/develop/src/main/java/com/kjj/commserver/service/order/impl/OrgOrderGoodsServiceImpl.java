package com.kjj.commserver.service.order.impl;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kjj.commserver.constant.FileConstant;
import com.kjj.commserver.dao.order.OrgOrderGoodsDao;
import com.kjj.commserver.entity.goods.aide.OrgGoodsReportVo;
import com.kjj.commserver.entity.goods.aide.OrgProductItemAide;
import com.kjj.commserver.entity.order.OrgOrder;
import com.kjj.commserver.entity.order.OrgOrderGoods;
import com.kjj.commserver.entity.order.aide.OrgCartAll;
import com.kjj.commserver.entity.order.aide.OrgOrderConstant;
import com.kjj.commserver.entity.order.aide.OrgOrderGoodsConstant;
import com.kjj.commserver.entity.order.aide.OrgOrderGoodsQuery;
import com.kjj.commserver.entity.user.aide.OrgUsersSession;
import com.kjj.commserver.service.order.OrgOrderGoodsService;
import com.kjj.commserver.service.swap.RxOrderService;
import com.kjj.commserver.util.DateFormatUtil;
import com.kjj.core.dao.BaseDao;
import com.kjj.core.service.BaseServiceImpl;

@Service
public class OrgOrderGoodsServiceImpl extends
		BaseServiceImpl<OrgOrderGoods, Integer> implements OrgOrderGoodsService {
	@Resource
	private OrgOrderGoodsDao orgOrderGoodsDao;
	@Resource
	private RxOrderService rxOrderService;

	@Override
	protected BaseDao<OrgOrderGoods, Integer> getBaseDao() {
		return orgOrderGoodsDao;
	}

	@Override
	public OrgOrderGoods lockQueryById(Integer orderGoodsId) {
		return orgOrderGoodsDao.selectById4Update(orderGoodsId);
	}

	@Override
	public void addBatch(OrgUsersSession orgUsersSession, OrgOrder orgOrder,
			List<OrgCartAll> listCartAll) {
		List<OrgOrderGoods> listGoods = new ArrayList<OrgOrderGoods>();
		OrgOrderGoods orderGoods = null;
		OrgProductItemAide itemAide = null;
		for (OrgCartAll cartAll : listCartAll) {
			orderGoods = new OrgOrderGoods();
			itemAide = cartAll.getOrgProductItemAll().getOrgProductItemAide();
			orderGoods.setOrderId(orgOrder.getOrderId());
			orderGoods.setOrderSerialNo(orgOrder.getSerialNo());
			orderGoods.setShopId(orgOrder.getShopId());
			orderGoods.setGoodsId(itemAide.getGoodsId());
			orderGoods.setGoodsSn(itemAide.getGoodsSn());
			orderGoods.setTradeSnapshootId(cartAll.getOrgProductItemAll()
					.getOrgProductItem().getLastTradeSnapshootId());
			orderGoods.setUnitAccounts(itemAide.getSourcePrice());
			orderGoods.setUnitDiscount(itemAide.getSourcePrice().subtract(
					itemAide.getRealPrice()));
			orderGoods.setUnitPrice(itemAide.getRealPrice());
			orderGoods.setAmount(itemAide.getUserBuy());
			orderGoods.setReturnAmount(0);
			orderGoods.setRefundAmount(0);
			orderGoods
					.setCommentStatus(OrgOrderGoodsConstant.COMMENT_STATUS_UNCOMMENT);
			listGoods.add(orderGoods);
		}
		// 批量添加
		addInBatch(listGoods);
		// 瑞星订单
		rxOrderService.add(orgUsersSession, orgOrder, listGoods);
	}

	@Override
	public List<OrgOrderGoods> queryByOrderIds(Collection<Integer> orderIds) {
		OrgOrderGoodsQuery query = new OrgOrderGoodsQuery();
		query.setOrderIds(orderIds);
		return queryList(query);
	}

	@Override
	public List<OrgOrderGoods> queryByOrderId(Integer orderId) {
		OrgOrderGoodsQuery query = new OrgOrderGoodsQuery();
		query.setOrderId(orderId);
		return queryList(query);
	}

	@Override
	public List<OrgOrderGoods> queryCommentByOrderId(Integer orderId) {
		OrgOrderGoodsQuery query = new OrgOrderGoodsQuery();
		query.setOrderId(orderId);
		return orgOrderGoodsDao.selectListComment(query);
	}

	@Override
	public List<OrgOrderGoods> query4ReturnByOrderId(Integer orderId) {
		OrgOrderGoodsQuery query = new OrgOrderGoodsQuery();
		query.setOrderId(orderId);
		query.setReturnLtBuy(true);
		query.setUnitAccountsNeZero(true);
		return queryList(query);
	}

	@Override
	public Page<OrgOrderGoods> queryPageListComment(
			OrgOrderGoods orgOrderGoods, Pageable pageable) {
		return orgOrderGoodsDao.selectPageListComment(orgOrderGoods, pageable);
	}

	@Override
	public long queryOtherCount(OrgOrderGoods query) {
		return orgOrderGoodsDao.selectOtherCount(query);
	}

	@Override
	public List<OrgOrderGoods> queryListComment(OrgOrderGoods query) {
		return orgOrderGoodsDao.selectListComment(query);
	}

	@Override
	public Long queryCountCanCommentByUserId(Integer userId) {
		OrgOrderGoodsQuery query = new OrgOrderGoodsQuery();
		query.setUserId(userId);
		// 订单状态为已完成的
		query.setOrderStatus(OrgOrderConstant.STATUS_FINISH);
		// 订单评论为未评价
		query.setCommentStatus(OrgOrderGoodsConstant.COMMENT_STATUS_UNCOMMENT);
		return queryCount(query);
	}

	@Override
	public Long queryCountCanNotCommentByUserId(Integer userId) {
		OrgOrderGoodsQuery query = new OrgOrderGoodsQuery();
		query.setUserId(userId);
		query.setOrderStatus(OrgOrderConstant.STATUS_FINISH);
		query.setCommentStatus(OrgOrderGoodsConstant.COMMENT_STATUS_COMMENTED);
		return queryCount(query);
	}

	@Override
	public List<OrgOrderGoods> queryList4OrderReport(OrgOrderGoods query) {
		return orgOrderGoodsDao.selectList4OrderReport(query);
	}
	
	@Override
	public Page<OrgGoodsReportVo> queryPageList4GoodsReport(OrgOrderGoods query,Pageable pageable) {
		return orgOrderGoodsDao.selectPageList4GoodsReport(query, pageable);
	}

	@Override
	public String exportExcel(OrgOrderGoodsQuery query) {
		List<OrgGoodsReportVo> orgGoodsList = orgOrderGoodsDao.selectList4GoodsReport(query);
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("商品销售统计");
		HSSFCellStyle style = workbook.createCellStyle();
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平
		
		//创建保留两位小数的样式
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
		
		// 创建表头
		HSSFRow rowTitle = sheet.createRow(0);
		if (query.getIsAsShop()) {
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 5));
		} else {
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));
		}
		
		HSSFCell cell0 = rowTitle.createCell(0);
		cell0.setCellStyle(style);
		String title = DateFormatUtil.formatDateTime(query.getCreateTimeStart())+"至"+DateFormatUtil.formatDateTime(query.getCreateTimeEnd())+"商品销售统计报表";
		cell0.setCellValue(title);
		
		if(query.getIsAsShop()){
			HSSFRow  rowHead = sheet.createRow(1);
			String[] heads = {"商品货号","商品名称","店铺","销量","平均价格（元）","总金额（元）"};
			for(int i=0;i<heads.length;i++){			
				HSSFCell cell = rowHead.createCell(i);
				cell.setCellStyle(style);
				cell.setCellValue(heads[i]);
			}
		}else{
			HSSFRow rowHead = sheet.createRow(1);
			String[] heads = {"商品货号","商品名称","销量","平均价格（元）","总金额（元）"};
			for(int i=0;i<heads.length;i++){			
				HSSFCell cell = rowHead.createCell(i);
				cell.setCellStyle(style);
				cell.setCellValue(heads[i]);
			}
		}
		
		for (int i = 0; i < orgGoodsList.size(); i++) {
			int cellCol=0;
			OrgGoodsReportVo item = orgGoodsList.get(i);
			HSSFRow rowData = sheet.createRow(i+2);
			
			HSSFCell cellData0 = rowData.createCell(cellCol);
			cellData0.setCellStyle(style);
			cellData0.setCellValue(item.getGoodsSn());
			
			HSSFCell cellData1 = rowData.createCell(++cellCol);
			cellData1.setCellStyle(style);
			cellData1.setCellValue(item.getGoodsName());
			
			if(query.getIsAsShop()){
				HSSFCell cellData2 = rowData.createCell(++cellCol);
				cellData2.setCellStyle(style);
				cellData2.setCellValue(item.getShopName());
			}
			
			HSSFCell cellData3 = rowData.createCell(++cellCol);
			cellData3.setCellValue(item.getAmountGoods().doubleValue());
			
			HSSFCell cellData4 = rowData.createCell(++cellCol);
			cellData4.setCellStyle(cellStyle);
			cellData4.setCellValue(item.getAvgPrice().doubleValue());
			
			HSSFCell cellData5 = rowData.createCell(++cellCol);
			cellData5.setCellStyle(cellStyle);
			cellData5.setCellValue(item.getTotalMoney().doubleValue());
		}
		
		String fileName = DateFormatUtil.formatDateTime(query.getCreateTimeStart())+"至"+DateFormatUtil.formatDateTime(query.getCreateTimeEnd())+"销售统计"+"_"+".xls";
		fileName = fileName.replaceAll(" ", "").replaceAll(":", "");
		
		try {
			FileOutputStream fos = new FileOutputStream(FileConstant.FILE_BASE_PATH+FileConstant.GOODS_REPORT+fileName);
			workbook.write(fos);
			fos.close();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return FileConstant.FILE_BASE_URL+FileConstant.GOODS_REPORT+fileName;
	}
}