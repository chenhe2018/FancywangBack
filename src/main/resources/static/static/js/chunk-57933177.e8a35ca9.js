(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-57933177"],{"3e3b":function(t,e,o){"use strict";o("b6ce")},5408:function(t,e,o){"use strict";o.r(e);var r=function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("div",{staticClass:"app-container"},[o("el-form",{ref:"form",attrs:{model:t.form,"label-width":"120px"}},[o("el-form-item",{attrs:{label:"UID"}},[o("el-input",{model:{value:t.form.uid,callback:function(e){t.$set(t.form,"uid",e)},expression:"form.uid"}})],1),t._v(" "),o("el-form-item",{attrs:{label:"预设接口"}},[o("el-input",{model:{value:t.form.url,callback:function(e){t.$set(t.form,"url",e)},expression:"form.url"}})],1),t._v(" "),o("el-form-item",{attrs:{label:"预设模板"}},[o("el-input",{attrs:{type:"textarea",rows:"5"},model:{value:t.form.json,callback:function(e){t.$set(t.form,"json",e)},expression:"form.json"}})],1),t._v(" "),o("el-form-item",{attrs:{label:"返回值"}},[o("el-input",{attrs:{type:"textarea",rows:"5"},model:{value:t.form.rtn,callback:function(e){t.$set(t.form,"rtn",e)},expression:"form.rtn"}})],1),t._v(" "),o("el-form-item",[o("el-button",{attrs:{type:"primary"},on:{click:t.onSubmit}},[t._v("提交")]),t._v(" "),o("el-button",{attrs:{type:"primary"},on:{click:t.onClear}},[t._v("清空")]),t._v(" "),o("el-button",{attrs:{type:"primary"},on:{click:t.onDownload}},[t._v("下载")])],1)],1)],1)},n=[],a=o("b775"),s={data:function(){return{form:{uid:"atc2019061231",url:"http://localhost:1024/download",json:'{"requestHead":{"channelName":"market.test","toKen":"BBJCKHSDHLJDFHJK"},"requestId":"atcMMHFSFEGFETGAA24356667ww465367","uid":"atc2019061231","salesStrategyCode":"fyyx00002","orderId":304820612901,"orderAmount":10800,"countryCode":"","mobilePhone":"","extendsInfo":""}',rtn:"null"}}},methods:{onDownload:function(){Object(a["a"])({url:this.form.url,method:"post",data:this.form.json,responseType:"blob",headers:{"Content-Type":"application/json; application/octet-stream"}}).then((function(t){console.log("response",t);var e=new Blob([t],{type:"application/zip"}),o=window.URL.createObjectURL(e),r=document.createElement("a");r.href=o,r.download="zip123.zip",r.click(),URL.revokeObjectURL(o)}))},onSubmit:function(){var t=this;this.$message({message:this.form.uid+"\r\n"+this.form.url,type:"warning"});var e=JSON.parse(this.form.json);console.log("模板解析",e),e["uid"]=this.form.uid,e["requestId"]=this.randomString(20),this.form.json=JSON.stringify(e),console.log("发起请求"),Object(a["a"])({url:this.form.url,method:"get",data:this.form.json}).then((function(e){console.log("response",e),e&&"success"===e.ack?t.form.rtn="成功":t.form.rtn="失败"}))},onClear:function(){this.form.uid="",this.form.rtn=""},randomString:function(t){t=t||32;for(var e="ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz2345678",o=e.length,r="",n=0;n<t;n++)r+=e.charAt(Math.floor(Math.random()*o));return r}}},l=s,i=(o("3e3b"),o("2877")),c=Object(i["a"])(l,r,n,!1,null,"54305da8",null);e["default"]=c.exports},b6ce:function(t,e,o){}}]);