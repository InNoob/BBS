<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="resource/css/normalize.css">
    <link rel="stylesheet" type="text/css" href="resource/css/myreset.css">
    <link rel="stylesheet" type="text/css" href="resource/css/topic.css">
    <script type="text/javascript" src="resource/js/topic.js"></script>
    <script type="text/javascript">
        AddListener(window,'scroll',function () {
            var top = document.getElementById('topcontainer');
            var logo =document.getElementById('logo');
            if(window.scrollY>60){
                top.className='top-scroll';
                logo.className='top-logoscroll';
                for(var i=0;i<document.getElementsByClassName('top-blockinfo').length;++i){
                    document.getElementsByClassName('top-blockinfo')[i].className = 'top-blockinfoscroll';
                }
            }else{
                top.className='top-container';
                logo.className='top-logo';
                // var e = document.getElementsByClassName('top-blockinfoscroll');
                for(var i=0;i<document.getElementsByClassName('top-blockinfoscroll').length;++i){
                    document.getElementsByClassName('top-blockinfoscroll')[i].className = 'top-blockinfo';
                }
            }
        })
    </script>
</head>
<body>
<div id="topcontainer" class="top-container">
        <div class="top-panel">
            <div id="logo" class="top-logo">
                <font color="orangered" >B</font>
                <font color="gold">o</font>
                <font color="orangered">B</font>
                <font color="gold">o</font>
                <font color="dodgerblue">S</font>
                <font color="limegreen">i</font>
            </div>
            <div class="top-blockbox">
                <div id="top-block-technology" class="top-blockinfo">
                    <a href="#"><span>技术交流</span></a>
                    <span>发帖：999</span>
                </div>
                <div id="top-block-dailylife" class="top-blockinfo">
                    <a href="#"><span>日常生活</span></a>
                    <span>发帖：999</span>
                </div>
                <div id="top-block-resource" class="top-blockinfo">
                    <a href="#"><span>资源分享</span></a>
                    <span>发帖：999</span>
                </div>
                <div id="top-block-official" class="top-blockinfo">
                    <a href="#"><span>官方公告</span></a>
                    <span>发帖：999</span>
                </div>
            </div>
            <div class="top-headimgbox" style="display:none">
                <div class="top-headimg ">
                    <a href="#"> <img src="resource/image/headimg.png" alt=""></a>
                </div>
                <span class="top-unread">9</span>
                <div class="top-outuserinfo">
                    <div class="top-userinfo">
                        <div class="top-headimg top-innerheadimg">
                            <a href="#"> <img src="resource/image/headimg.png" alt=""></a>
                        </div>
                        <b>祈雨芊叶</b>
                        <div style="width:87%;margin:20px auto;text-align:left">
                            <span style="text-align:left">发帖：9999</span>
                            <span style="width:66%;text-align:right">回帖：9999</span>
                        </div>
                        <div class="top-mark">
                            <span>等级</span>
                            <span class="top-level" style="background-position:-153px -44px;"></span>
                            <span class="top-markbox">
                                <span class="top-markbar"></span>
                            </span>
                        </div>
                        <div class="top-point">
                            9999/<span style="color:#ccc">9999</span> 
                        </div>
                        <div class="top-maskbar">
                            <hr>
                        </div>
                        <div class="top-buttonbox">
                            <div class="top-button">
                                <a href="#">
                                    <i class="top-i top-i-u"></i>
                                    <span>个人中心</span>
                                </a>
                            </div>
                            <div class="top-button">
                                <a href="#">
                                    <i class="top-i top-i-m"></i>
                                    <span>消息提醒</span>
                                </a>
                            </div>
                            <div class="top-button">
                                <a href="#">
                                    <i class="top-i top-i-t"></i>
                                    <span>我的帖子</span>
                                </a>
                            </div>
                            <div class="top-button">
                                <a href="#">
                                    <i class="top-i top-i-f"></i>
                                    <span>我的收藏</span>
                                </a>
                            </div>
                        </div>
                        <div class="top-loginout">
                            <a href="#"><span>注销</span></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="top-sign" style="display:block">
                <a href="#"><span>登陆</span></a>
                <span>|</span> 
                <a href="#"><span>注册</span></a> 
            </div>
            <div class="top-searchbox">
                <input id="top-search" list="top-autocomple" name="" value="">
                <datalist id="top-autocomple">                    
                    <option value="JasonBourne"></option>
                    <option value="Well Smith"></option>
                    <option value="Winter worth"></option>
                    <option value="哈巴卵">habaluan</option>
                    <option value="狗比">goubi</option>
                </datalist>
                <button type="button"></button>
            </div>
            
        </div> 
    </div>
</body>
</html>