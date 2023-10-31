import {useState,useEffect} from 'react';
import Share from "../share/Share";
import './feed.css';
import Post from '../post/Post';
import {Question} from '../../models/Question'
import questionService from '../../services/questionService';


export default function Feed(){

  const [questions,setQuestions] = useState<Question[]>([]);


  useEffect( () =>  {
     questionService.getQuestions<Question[]>('') 
      .then(data => setQuestions(data))
      .catch(error => console.error(error));
  }, []);

  return ( 
        <div className='feed'>
            <div className="feedWrapper">
              <Share/>
              {questions.length > 0 ?   questions.map((q) =>(
                q.answers.length > 0 &&  <Post key = {q.questionId} question = {q} answer={q.answers[0]} isFeed={true}/>
              ))  : <div>No Posts Yet </div>}  
            </div>
        </div>
  )
}
