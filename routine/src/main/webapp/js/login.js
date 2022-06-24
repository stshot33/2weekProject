var jskey = "15d3bb1344db4e3cf56966e2788148b8";

Kakao.init(jskey);
console.log(Kakao.isInitialized()); // sdk초기화여부판단

function loginWithKakao() {
    Kakao.Auth.login({
      success: function (response) {
        Kakao.API.request({
          url: '/v2/user/me',
          success: function (response) {
          	console.log(response);
          	var nick = response.kakao_account.profile.nickname;
          	var id = response.id;
          	
          	console.log(id);
          	location.href = "signIn?nick="+nick + "&id=" + id;
          },
          fail: function (error) {
            console.log(error)
          },
        })
      },
      fail: function (error) {
        console.log(error)
      },
    })
  }
  // 아래는 데모를 위한 UI 코드입니다.
  displayToken()
  function displayToken() {
    const token = getCookie('authorize-access-token')
    if(token) {
      Kakao.Auth.setAccessToken(token)
      Kakao.Auth.getStatusInfo(({ status }) => {
        if(status === 'connected') {
          document.getElementById('token-result').innerText = 'login success. token: ' + Kakao.Auth.getAccessToken()
        } else {
          Kakao.Auth.setAccessToken(null)
        }
      })
    }
  }
  function getCookie(name) {
    const value = "; " + document.cookie;
    const parts = value.split("; " + name + "=");
    if (parts.length === 2) return parts.pop().split(";").shift();
  }
  
  function kakaoLogout() {
  	Kakao.isInitialized();
  
  	console.log(Kakao.Auth.getAccessToken());
  
    if (!Kakao.Auth.getAccessToken()) {
        alert('Not logged in.');
        location.href = "logout";
    }
    Kakao.Auth.logout(function() {
        location.href = "logout";
    });
}