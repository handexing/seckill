//存放主要交互逻辑代码
var seckill={
		//封装秒杀相关ajax的url
		URL:{
			now:function(){
				return '/seckill/seckill/time/now';
			}
		},
		handleSeckKill:function(){//处理秒杀逻辑
			
		},
		validatePhone:function(phone){
			if(phone&&phone.length==11 && !isNaN(phone)){
				return true;
			}else{
				return false;
			}
		},
		countdown:function(seckillId,nowTime,startTime,endTime){
			var seckillBox = $('#seckill-box');
			if(nowTime>endTime){
				//秒杀结束
				seckillBox.html('秒杀结束！');
			}else if(nowTime<startTime){
				//秒杀为开始
				//及时事件绑定
				var killTime = new Date(startTime + 1000);
				seckillBox.countdown(killTime,function(event){
					var farmat = event.strftime('秒杀倒计时：%D天 %H时 %M分 %S秒');
					seckillBox.html(farmat);
				}).on('finish.countdown',function(){//时间完成后回调事件
					//获取秒杀地址
					seckill.handleSeckKill();
				});
			}else{
				//秒杀开始
				seckill.handleSeckKill();
			}
		},
		//详情页秒杀逻辑
		detail:{
			//详情页初始化
			init:function(params){
				//用户手机验证，及时交互
				//在cookie查找手机号
				var killPhone=$.cookie('killPhone');
				//验证手机号
				if (!seckill.validatePhone(killPhone)) {
					//绑定手机号
					var killPhoneModal = $('#killPhoneModal');//显示弹出层
					killPhoneModal.modal({
						show:true,//显示弹出层
						backdrop:'static',//禁止位置关闭
						keyboard:false//关闭键盘事件
					});
					$('#killPhoneBtn').click(function(){
						var inputPhone = $('#killphoneKey').val();
						if (!seckill.validatePhone(killPhone)) {
							//写入cookie
							$.cookie('killPhone',inputPhone,{expires:7,path:'/seckill'});
							//刷新页面
							window.location.reload();
						}else{
							$('#killphoneMessage').hide().html('<label calss="lable label-danger">手机号错误！</lablel>').show(300);
						}
					});
				}
				//登陆,及时面板显示
				var startTime=params['startTime'];
				var endTime=params['endTime'];
				var seckillId=params['seckillId'];
				$.get(seckill.URL.now(),{},function(result){
					if(result && result['success']){
						var nowTime = result['data'];
						seckill.countdown(seckillId, nowTime, startTime, endTime);
					}else{
						console.log('result='+result);
					}
				});
			}
		}
}