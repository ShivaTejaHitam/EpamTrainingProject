import axios , {AxiosResponse , AxiosError} from 'axios';
import { QuestionRequest } from '../models/QuestionRequest';

class QuestionService{
    private instance = axios.create({
        baseURL: 'http://localhost:8099/questions', 
        timeout: 5000, 
    });

    async getQuestions<T>(url: string): Promise<T> {
        try {
          const response: AxiosResponse<T> = await this.instance.get(url);
          return response.data;
        } catch (error) {
          throw new Error('Error fetching data: ' + (error as AxiosError).message);
        }
    }

    async postQuestion<T>(url: string,question : QuestionRequest): Promise<T> {
      try {
        const response: AxiosResponse<T> = await this.instance.post(url,question);
        return response.data;
      } catch (error) {
        throw new Error('Error posting question: ' + (error as AxiosError).message);
      }
    }

    async updateQuestion<T>(url: string,question : QuestionRequest): Promise<T> {
      try {
        const response: AxiosResponse<T> = await this.instance.patch(url,question);
        return response.data;
      } catch (error) {
        throw new Error('Error updating question: ' + (error as AxiosError).message);
      }
    }

    async deleteQuestion<T>(url: string,questionId : number): Promise<T> {
      try {
        const response: AxiosResponse<T> = (await this.instance.delete(url));
        return response.data;
      } catch (error) {
        throw new Error('Error updating question: ' + (error as AxiosError).message);
      }
    }

}

export default new QuestionService();