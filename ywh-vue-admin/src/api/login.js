import request from '@/utils/request'

export function login(username, password) {
  return request({
    url: '/auth/login',
    method: 'post',
    data: {
      username,
      password
    }
  })
}

export function getInfo(token) {
  return request({
    url: '/auth/userInfo',
    method: 'get',
    params: { token }
  })
}

export function logOut() {
  return request({
    url: '/auth/logOut',
    method: 'post'
  })
}
