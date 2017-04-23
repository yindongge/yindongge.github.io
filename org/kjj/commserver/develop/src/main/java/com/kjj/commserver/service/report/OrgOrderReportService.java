package com.kjj.commserver.service.report;

import com.kjj.commserver.entity.report.aide.OrgOrderReportQuery;

public interface OrgOrderReportService {
	
	/**
	 * 导出订单报表
	 * @param query
	 * @return
	 */
	String exportOrderExcel(OrgOrderReportQuery query);

}
