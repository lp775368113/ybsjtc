/**
 * 计算字符串的长度,中文字符按照两个字符来计算
 */
String.prototype.getLength = function() {
	var reLen = 0;
	for ( var i = 0; i < this.length; i = i + 1) {
		if (this.charCodeAt(i) < 27 || this.charCodeAt(i) > 126) {
			reLen += 2;
		} else {
			reLen += 1;
		}
	}
	return reLen;
}

/**
 * 去掉字符串两边的空格
 */
String.prototype.trim = function() {
	return this.replace(/(^[\s]*)|([\s]*$)/g, "");
}