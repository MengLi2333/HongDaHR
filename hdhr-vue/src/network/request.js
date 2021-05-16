import axios from 'axios'
import qs from 'qs'

export const HOST = 'http://localhost:8888/'

export function request(options) {
  const instance = axios.create({
    baseURL: HOST,
    withCredentials: true
  })
  instance.interceptors.request.use(req => {
    if (req.method === 'post') {
      req.data = qs.stringify(req.data);
    }
    return req;
  })
  return instance(options)
}

export function handleResult(res, _this, onSuccess) {
  console.log(2); // FIXME
  if (res.data.status === 200) {
    _this.$message.success('登录成功')
    onSuccess(_this)
  } else {
    if (res.data.msg !== null) {
      _this.$message.error('登录失败,', res.data.msg)
    } else {
      _this.$message.error('登录失败, 服务器繁忙')
    }
  }
}
