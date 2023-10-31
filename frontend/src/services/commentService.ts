import axios , {AxiosResponse , AxiosError} from 'axios';
import { CommentRequest } from '../models/CommentRequest';


class CommentService{
    private instance = axios.create({
        baseURL: 'http://localhost:8888/comments', 
        timeout: 5000, 
    });

    
    async postComment<T>(url: string,comment : CommentRequest): Promise<T> {
      try {
        const response: AxiosResponse<T> = await this.instance.post(url,comment);
        return response.data;
      } catch (error) {
        throw new Error('Error posting comment: ' + (error as AxiosError).message);
      }
    }

    async updateComment<T>(url: string,comment : CommentRequest): Promise<T> {
      try {
        const response: AxiosResponse<T> = await this.instance.patch(url,comment);
        return response.data;
      } catch (error) {
        throw new Error('Error updating comment: ' + (error as AxiosError).message);
      }
    }

    async deleteComment<T>(url: string,questionId : number): Promise<T> {
      try {
        const response: AxiosResponse<T> = (await this.instance.delete(url));
        return response.data;
      } catch (error) {
        throw new Error('Error deleting question: ' + (error as AxiosError).message);
      }
    }
}

export default new CommentService();
