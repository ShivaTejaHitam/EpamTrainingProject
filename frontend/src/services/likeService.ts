import axios , {AxiosResponse , AxiosError} from 'axios';
import { LikeRequest } from '../models/LikeRequest';

class LikeService{
    private instance = axios.create({
        baseURL: 'http://localhost:8092/likes', 
        timeout: 5000, 
    });

    async likeAnswer<T>(url: string, like : LikeRequest): Promise<T> {
        try {
          const response: AxiosResponse<T> = await this.instance.post(url,like);
          return response.data;
        } catch (error) {
          throw new Error('Error posting data: ' + (error as AxiosError).message);
        }
    }

    async dislikeAnswer<T>(url: string,likeId : number): Promise<T> {
        try {
          const response: AxiosResponse<T> = await this.instance.delete(url);
          return response.data;
        } catch (error) {
          throw new Error('Error deleting data: ' + (error as AxiosError).message);
        }
    }
}

export default new LikeService();