(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-72b59745"],{"3bc2":function(t,e,r){},5408:function(t,e,r){"use strict";r.r(e);var o=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",{staticClass:"app-container"},[r("el-form",{ref:"form",attrs:{model:t.form,"label-width":"120px"}},[r("el-form-item",{attrs:{label:"UID"}},[r("el-input",{model:{value:t.form.uid,callback:function(e){t.$set(t.form,"uid",e)},expression:"form.uid"}})],1),t._v(" "),r("el-form-item",{attrs:{label:"预设接口"}},[r("el-input",{model:{value:t.form.url,callback:function(e){t.$set(t.form,"url",e)},expression:"form.url"}})],1),t._v(" "),r("el-form-item",{attrs:{label:"预设模板"}},[r("el-input",{attrs:{type:"textarea",rows:"5"},model:{value:t.form.json,callback:function(e){t.$set(t.form,"json",e)},expression:"form.json"}})],1),t._v(" "),r("el-form-item",{attrs:{label:"返回值"}},[r("el-input",{attrs:{type:"textarea",rows:"5"},model:{value:t.form.rtn,callback:function(e){t.$set(t.form,"rtn",e)},expression:"form.rtn"}})],1),t._v(" "),r("el-form-item",[r("el-button",{attrs:{type:"primary"},on:{click:t.onSubmit}},[t._v("提交")]),t._v(" "),r("el-button",{attrs:{type:"primary"},on:{click:t.onClear}},[t._v("清空")])],1)],1)],1)},n=[],a=r("b775"),s={data:function(){return{form:{uid:"atc2019061231",url:"http://localhost:8080/hello",json:'{"requestHead":{"channelName":"market.test","toKen":"BBJCKHSDHLJDFHJK"},"requestId":"atcMMHFSFEGFETGAA24356667ww465367","uid":"atc2019061231","salesStrategyCode":"fyyx00002","orderId":304820612901,"orderAmount":10800,"countryCode":"","mobilePhone":"","extendsInfo":""}',rtn:"null"}}},methods:{onSubmit:function(){var t=this;this.$message({message:this.form.uid+"\r\n"+this.form.url,type:"warning"});var e=JSON.parse(this.form.json);console.log("模板解析",e),e["uid"]=this.form.uid,e["requestId"]=this.randomString(20),this.form.json=JSON.stringify(e),console.log("发起请求"),Object(a["a"])({url:this.form.url,method:"get",data:this.form.json}).then((function(e){console.log("response",e),e&&"success"===e.ack?t.form.rtn="成功":t.form.rtn="失败"}))},onClear:function(){this.form.uid="",this.form.rtn=""},randomString:function(t){t=t||32;for(var e="ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz2345678",r=e.length,o="",n=0;n<t;n++)o+=e.charAt(Math.floor(Math.random()*r));return o}}},l=s,i=(r("f55a"),r("2877")),m=Object(i["a"])(l,o,n,!1,null,"038b128e",null);e["default"]=m.exports},f55a:function(t,e,r){"use strict";var o=r("3bc2"),n=r.n(o);n.a}}]);