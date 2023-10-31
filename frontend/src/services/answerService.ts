import axios , {AxiosResponse , AxiosError} from 'axios';
import { AnswerRequest } from '../models/AnswerRequest';


class AnswerService{
    private instance = axios.create({
        baseURL: 'http://localhost:8090/answers', 
        timeout: 5000, 
    });

    
    async postAnswer<T>(url: string,answer : AnswerRequest): Promise<T> {
      try {
        const response: AxiosResponse<T> = await this.instance.post(url,answer);
        return response.data;
      } catch (error) {
        throw new Error('Error posting answer: ' + (error as AxiosError).message);
      }
    }

    async updateAnswer<T>(url: string,answer : AnswerRequest): Promise<T> {
      try {
        const response: AxiosResponse<T> = await this.instance.patch(url,answer);
        return response.data;
      } catch (error) {
        throw new Error('Error updating answer: ' + (error as AxiosError).message);
      }
    }

    async deleteAnswer<T>(url: string,questionId : number): Promise<T> {
      try {
        const response: AxiosResponse<T> = (await this.instance.delete(url));
        return response.data;
      } catch (error) {
        throw new Error('Error deleting question: ' + (error as AxiosError).message);
      }
    }
}

export default new AnswerService();
