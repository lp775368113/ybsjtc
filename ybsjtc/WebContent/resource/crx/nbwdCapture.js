;
(function() {
	var Canvas2Image = function() {

		// check if support sth.
		var $support = function() {
			var canvas = document.createElement('canvas'), ctx = canvas
					.getContext('2d');

			return {
				canvas : !!ctx,
				imageData : !!ctx.getImageData,
				dataURL : !!canvas.toDataURL,
				btoa : !!window.btoa
			};
		}();

		var downloadMime = 'image/octet-stream';

		function scaleCanvas(canvas, width, height) {
			var w = canvas.width, h = canvas.height;
			if (width == undefined) {
				width = w;
			}
			if (height == undefined) {
				height = h;
			}

			var retCanvas = document.createElement('canvas');
			var retCtx = retCanvas.getContext('2d');
			retCanvas.width = width;
			retCanvas.height = height;
			retCtx.drawImage(canvas, 0, 0, w, h, 0, 0, width, height);
			return retCanvas;
		}

		function getDataURL(canvas, type, width, height) {
			canvas = scaleCanvas(canvas, width, height);
			return canvas.toDataURL(type);
		}

		function formatDateTime(inputTime) {
			var date = new Date(inputTime);
			var y = date.getFullYear();
			var m = date.getMonth() + 1;
			m = m < 10 ? ('0' + m) : m;
			var d = date.getDate();
			d = d < 10 ? ('0' + d) : d;
			var h = date.getHours();
			h = h < 10 ? ('0' + h) : h;
			var minute = date.getMinutes();
			var second = date.getSeconds();
			minute = minute < 10 ? ('0' + minute) : minute;
			second = second < 10 ? ('0' + second) : second;
			return y + m + d + h + minute + second;
		}

		function saveFile(strData, filename, filetype) {
			if (!filename) {
				filename = formatDateTime(new Date());
			}

			if (!filetype)
				filetype = ".png";

			var save_link = document.createElementNS(
					'http://www.w3.org/1999/xhtml', 'a');
			save_link.href = strData;
			save_link.download = filename + filetype;

			var event = document.createEvent('MouseEvents');
			event.initMouseEvent('click', true, false, window, 0, 0, 0, 0, 0,
					false, false, false, false, 0, null);
			save_link.dispatchEvent(event);

			// document.location.href = strData;
		}

		function genImage(strData) {
			var img = document.createElement('img');
			img.src = strData;
			return img;
		}
		function fixType(type) {
			type = type.toLowerCase().replace(/jpg/i, 'jpeg');
			var r = type.match(/png|jpeg|bmp|gif/)[0];
			return 'image/' + r;
		}
		function encodeData(data) {
			if (!window.btoa) {
				throw 'btoa undefined'
			}
			var str = '';
			if (typeof data == 'string') {
				str = data;
			} else {
				for (var i = 0; i < data.length; i++) {
					str += String.fromCharCode(data[i]);
				}
			}

			return btoa(str);
		}
		function getImageData(canvas) {
			var w = canvas.width, h = canvas.height;
			return canvas.getContext('2d').getImageData(0, 0, w, h);
		}
		function makeURI(strData, type) {
			return 'data:' + type + ';base64,' + strData;
		}

		/**
		 * create bitmap image 按照规则生成图片响应头和响应体
		 */
		var genBitmapImage = function(oData) {

			//
			// BITMAPFILEHEADER:
			// http://msdn.microsoft.com/en-us/library/windows/desktop/dd183374(v=vs.85).aspx
			// BITMAPINFOHEADER:
			// http://msdn.microsoft.com/en-us/library/dd183376.aspx
			//

			var biWidth = oData.width;
			var biHeight = oData.height;
			var biSizeImage = biWidth * biHeight * 3;
			var bfSize = biSizeImage + 54; // total header size = 54 bytes

			//
			// typedef struct tagBITMAPFILEHEADER {
			// WORD bfType;
			// DWORD bfSize;
			// WORD bfReserved1;
			// WORD bfReserved2;
			// DWORD bfOffBits;
			// } BITMAPFILEHEADER;
			//
			var BITMAPFILEHEADER = [
			// WORD bfType -- The file type signature; must be "BM"
			0x42, 0x4D,
			// DWORD bfSize -- The size, in bytes, of the bitmap file
			bfSize & 0xff, bfSize >> 8 & 0xff, bfSize >> 16 & 0xff,
					bfSize >> 24 & 0xff,
					// WORD bfReserved1 -- Reserved; must be zero
					0, 0,
					// WORD bfReserved2 -- Reserved; must be zero
					0, 0,
					// DWORD bfOffBits -- The offset, in bytes, from the
					// beginning of the BITMAPFILEHEADER structure to the bitmap
					// bits.
					54, 0, 0, 0 ];

			//
			// typedef struct tagBITMAPINFOHEADER {
			// DWORD biSize;
			// LONG biWidth;
			// LONG biHeight;
			// WORD biPlanes;
			// WORD biBitCount;
			// DWORD biCompression;
			// DWORD biSizeImage;
			// LONG biXPelsPerMeter;
			// LONG biYPelsPerMeter;
			// DWORD biClrUsed;
			// DWORD biClrImportant;
			// } BITMAPINFOHEADER, *PBITMAPINFOHEADER;
			//
			var BITMAPINFOHEADER = [
			// DWORD biSize -- The number of bytes required by the structure
			40, 0, 0, 0,
			// LONG biWidth -- The width of the bitmap, in pixels
			biWidth & 0xff, biWidth >> 8 & 0xff, biWidth >> 16 & 0xff,
					biWidth >> 24 & 0xff,
					// LONG biHeight -- The height of the bitmap, in pixels
					biHeight & 0xff, biHeight >> 8 & 0xff,
					biHeight >> 16 & 0xff, biHeight >> 24 & 0xff,
					// WORD biPlanes -- The number of planes for the target
					// device. This value must be set to 1
					1, 0,
					// WORD biBitCount -- The number of bits-per-pixel, 24
					// bits-per-pixel -- the bitmap
					// has a maximum of 2^24 colors (16777216, Truecolor)
					24, 0,
					// DWORD biCompression -- The type of compression, BI_RGB
					// (code 0) -- uncompressed
					0, 0, 0, 0,
					// DWORD biSizeImage -- The size, in bytes, of the image.
					// This may be set to zero for BI_RGB bitmaps
					biSizeImage & 0xff, biSizeImage >> 8 & 0xff,
					biSizeImage >> 16 & 0xff, biSizeImage >> 24 & 0xff,
					// LONG biXPelsPerMeter, unused
					0, 0, 0, 0,
					// LONG biYPelsPerMeter, unused
					0, 0, 0, 0,
					// DWORD biClrUsed, the number of color indexes of palette,
					// unused
					0, 0, 0, 0,
					// DWORD biClrImportant, unused
					0, 0, 0, 0 ];

			var iPadding = (4 - ((biWidth * 3) % 4)) % 4;

			var aImgData = oData.data;

			var strPixelData = '';
			var biWidth4 = biWidth << 2;
			var y = biHeight;
			var fromCharCode = String.fromCharCode;

			do {
				var iOffsetY = biWidth4 * (y - 1);
				var strPixelRow = '';
				for (var x = 0; x < biWidth; x++) {
					var iOffsetX = x << 2;
					strPixelRow += fromCharCode(aImgData[iOffsetY + iOffsetX
							+ 2])
							+ fromCharCode(aImgData[iOffsetY + iOffsetX + 1])
							+ fromCharCode(aImgData[iOffsetY + iOffsetX]);
				}

				for (var c = 0; c < iPadding; c++) {
					strPixelRow += String.fromCharCode(0);
				}

				strPixelData += strPixelRow;
			} while (--y);

			var strEncoded = encodeData(BITMAPFILEHEADER
					.concat(BITMAPINFOHEADER))
					+ encodeData(strPixelData);

			return strEncoded;
		};

		/**
		 * saveAsImage
		 * 
		 * @param canvasElement
		 * @param {String}
		 *            image type
		 * @param {Number}
		 *            [optional] png width
		 * @param {Number}
		 *            [optional] png height
		 */
		var saveAsImage = function(canvas, width, height, type,filename) {
			if ($support.canvas && $support.dataURL) {
				if (typeof canvas == "string") {
					canvas = document.getElementById(canvas);
				}
				if (type == undefined) {
					type = 'png';
				}
				var filetype = "."+type;
				type = fixType(type);
				if (/bmp/.test(type)) {
					var data = getImageData(scaleCanvas(canvas, width, height));
					var strData = genBitmapImage(data);
					saveFile(makeURI(strData, downloadMime),filename,filetype);
				} else {
					var strData = getDataURL(canvas, type, width, height);
					saveFile(strData.replace(type, downloadMime),filename,filetype);
				}
			}
		};

		var convertToImage = function(canvas, width, height, type) {
			if ($support.canvas && $support.dataURL) {
				if (typeof canvas == "string") {
					canvas = document.getElementById(canvas);
				}
				if (type == undefined) {
					type = 'png';
				}
				type = fixType(type);

				if (/bmp/.test(type)) {
					var data = getImageData(scaleCanvas(canvas, width, height));
					var strData = genBitmapImage(data);
					return genImage(makeURI(strData, 'image/bmp'));
				} else {
					var strData = getDataURL(canvas, type, width, height);
					return genImage(strData);
				}
			}
		};

		return {
			saveAsImage : saveAsImage,
			saveAsPNG : function(canvas, width, height) {
				return saveAsImage(canvas, width, height, 'png');
			},
			saveAsJPEG : function(canvas, width, height) {
				return saveAsImage(canvas, width, height, 'jpeg');
			},
			saveAsGIF : function(canvas, width, height) {
				return saveAsImage(canvas, width, height, 'gif');
			},
			saveAsBMP : function(canvas, width, height) {
				return saveAsImage(canvas, width, height, 'bmp');
			},

			convertToImage : convertToImage,
			convertToPNG : function(canvas, width, height) {
				return convertToImage(canvas, width, height, 'png');
			},
			convertToJPEG : function(canvas, width, height) {
				return convertToImage(canvas, width, height, 'jpeg');
			},
			convertToGIF : function(canvas, width, height) {
				return convertToImage(canvas, width, height, 'gif');
			},
			convertToBMP : function(canvas, width, height) {
				return convertToImage(canvas, width, height, 'bmp');
			}
		};

	};

	var whenReady = function(fn) { // 这个函数返回whenReady()函数
		var funcs = []; // 当获得事件时，要运行的函数
		var ready = false; // 当触发事件处理程序时,切换为true

		// 当文档就绪时,调用事件处理程序
		function handler(e) {
			if (ready)
				return; // 确保事件处理程序只完整运行一次

			// 如果发生onreadystatechange事件，但其状态不是complete的话,那么文档尚未准备好
			if (e.type === 'onreadystatechange'
					&& document.readyState !== 'complete') {
				return;
			}

			// 运行所有注册函数
			// 注意每次都要计算funcs.length
			// 以防这些函数的调用可能会导致注册更多的函数
			for (var i = 0; i < funcs.length; i++) {
				funcs[i].call(document);
			}
			// 事件处理函数完整执行,切换ready状态, 并移除所有函数
			ready = true;
			funcs = null;
		}
		// 为接收到的任何事件注册处理程序
		if (document.addEventListener) {
			document.addEventListener('DOMContentLoaded', handler, false);
			document.addEventListener('readystatechange', handler, false); // IE9+
			window.addEventListener('load', handler, false);
		} else if (document.attachEvent) {
			document.attachEvent('onreadystatechange', handler);
			window.attachEvent('onload', handler);
		}

		if (ready) {
			fn.call(document);
		} else {
			funcs.push(fn);
		}
	};

	// 截屏通讯代码
	var _capture = function() {
		var that = this;
		this.reqEvent = '';
		this._dom = '';
		this.eventQueen = {};
		this.evnetNo = 1;

		var snd = function(msg, callback) {
			var en = that.evnetNo;
			msg["eventno"] = en;
			that.eventQueen["event" + en] = callback;
			that._dom.innerText = JSON.stringify(msg);
			that._dom.dispatchEvent(that.reqEvent);
			that.evnetNo++;
		};

		var check = function(callback) {
			if (that._dom) {
				snd({
					cmd : "heart"
				}, function(msg) {
					callback(msg);
				});
			} else {
				callback({
					ret : false,
					code : '1001'
				});
			}
		};

		this.init = function() {
			// 生成通道
			var _domId = "_nbwdCaptureReqDiv";
			that._dom = document.createElement('div');
			that._dom.id = _domId;
			that._dom.style.display = 'none';
			document.body.appendChild(that._dom);

			// 初始化发送事件
			that.reqEvent = document.createEvent('Event');
			that.reqEvent.initEvent('nbwdRequestEvent', true, true);
			// 注册回调事件
			that._dom.addEventListener('nbwdResponseEvent', function(event) {
				event.preventDefault();
				var res = that._dom.innerText;
				that._dom.isres = false;
				that._dom.innerText = '';
				if (res) {
					var msg = JSON.parse(res);
					if (msg.eventno) {
						var cb = that.eventQueen["event" + msg.eventno];
						delete that.eventQueen["event" + msg.eventno];
						if (cb) {
							delete msg.eventno;
							cb(msg);
						}
					}
				}
			});
		};

		this.capture = function(callback) {
			if (that._dom) {
				snd({
					cmd : "capture"
				}, function(msg) {
					callback(msg);
				});
			} else {
				callback({
					ret : false,
					code : '1001'
				});
			}
		};

		this.captureAsSave = function(filename, filetype) {
			that.capture(function(res) {
				if (res.ret == true) {
					var canvas = document.createElement("canvas");
					canvas.width = document.documentElement.scrollWidth;
					canvas.height = document.documentElement.scrollHeight;
					var ctx = canvas.getContext("2d");
					var img = new Image();

					img.onload = function() {
						ctx.drawImage(img, 0, 0);
						new Canvas2Image().saveAsImage(canvas,
								document.documentElement.scrollWidth,
								document.documentElement.scrollHeight,filetype,filename);
					};
					img.src = res.result;
				}
			});
		}

		return this;
	};

	var _c = new _capture();

	// dom 加载完后初始化通讯
	whenReady(function() {
		_c.init();
	});

	// 注入对外调用口
	window.nbwd = {};
	window.nbwd.capture = function(callback) {
		new _c.capture(callback);
	};
	window.nbwd.captureAsSave = function(filename, filetype) {
		new _c.captureAsSave(filename, filetype);
	};
})();
