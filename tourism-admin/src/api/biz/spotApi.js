import { baseRequest } from '@/utils/request'

const request = (url, ...arg) => baseRequest(`/biz/spot/` + url, ...arg)

export default {

	page(data) {
		return request('page', data, 'get')
	},

	submitForm(data, edit = false) {
		return request(edit ? 'edit' : 'add', data)
	},

	remove(data) {
		return request('delete', data)
	},

	detail(data) {
		return request('detail', data, 'get')
	},

  options(){
    return request('namelist',null,'get')
  }
}
