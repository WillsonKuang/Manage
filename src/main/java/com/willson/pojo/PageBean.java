package com.willson.pojo;

import java.util.List;

@SuppressWarnings("rawtypes")
public class PageBean {

	// 传递的参数或是配置的参数
	private Long currentPage; // 当前页
	private Long pageSize; // 每页显示多少条记录

	// 查询数据库
	private List recordList; // 本页的数据列表
	private Long recordCount; // 总记录数

	// 计算
	private Long pageCount; // 总页数
	private Long beginPageIndex; // 页码列表的开始索引（包含）
	private Long endPageIndex; // 页码列表的结束索引（包含）
	
	public PageBean() {
		
	}

	/**
	 * 只接受4个必要的属性，会自动的计算出其他3个属性的值
	 * 
	 * @param currentPage  当前页码
	 * @param pageSize     分页大小
	 * @param recordList   分数数据
	 * @param recordCount  总数据行数
	 */
	public PageBean(Long currentPage, Long pageSize, List recordList, Long recordCount) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.recordList = recordList;
		this.recordCount = recordCount;

		// 计算 pageCount
		pageCount = (recordCount + pageSize - 1) / pageSize;

		// 计算 beginPageIndex 与 endPageIndex
		// >> 总页码小于等于10页时，全部显示
		if (pageCount <= 10L) {
			beginPageIndex = 1L;
			endPageIndex = pageCount;
		}
		// >> 总页码大于10页时，就只显示当前页附近的共10个页码
		else {
			// 默认显示 前4页 + 当前页 + 后5页
			beginPageIndex = currentPage - 4; // 7 - 4 = 3;
			endPageIndex = currentPage + 5; // 7 + 5 = 12; --> 3 ~ 12

			// 如果前面不足4个页码时，则显示前10页
			if (beginPageIndex < 1L) {
				beginPageIndex = 1L;
				endPageIndex = 10L;
			}
			// 如果后面不足5个页码时，则显示后10页
			else if (endPageIndex > pageCount) {
				endPageIndex = pageCount;
				beginPageIndex = pageCount - 9;
			}
		}
	}

	public List getRecordList() {
		return recordList;
	}

	public void setRecordList(List recordList) {
		this.recordList = recordList;
	}

	public Long getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Long currentPage) {
		this.currentPage = currentPage;
	}

	public Long getPageCount() {
		return pageCount;
	}

	public void setPageCount(Long pageCount) {
		this.pageCount = pageCount;
	}

	public Long getPageSize() {
		return pageSize;
	}

	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}

	public Long getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(Long recordCount) {
		this.recordCount = recordCount;
	}

	public Long getBeginPageIndex() {
		return beginPageIndex;
	}

	public void setBeginPageIndex(Long beginPageIndex) {
		this.beginPageIndex = beginPageIndex;
	}

	public Long getEndPageIndex() {
		return endPageIndex;
	}

	public void setEndPageIndex(Long endPageIndex) {
		this.endPageIndex = endPageIndex;
	}
}