package com.knower.common.util;

public enum IdGeneratorEnum {
	
	/**树ID*/
	TREE_ID("mid_ref_portfolio", "tree_id", "TREE"),
	/**树节点ID*/
	TREE_NODE_ID("mid_ref_portfolio", "tree_node_id", "N"),
	/**规则ID**/
	RULE_ID("mid_ref_portfoliorule", "rule_id", "R");

	
    // 成员变量
    private String tableName; 
    private String columnName;
    private String initial;
    
	// 构造方法
    private IdGeneratorEnum(String tableName ,String columnName,String initial) {
        this.setTableName(tableName);
        this.columnName = columnName;
        this.initial = initial;
    }

	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getInitial() {
		return initial;
	}
	public void setInitial(String initial) {
		this.initial = initial;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
}
