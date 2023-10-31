import React from 'react';
import './advertisement.css';
import {AdProp} from '../../models/AdProp';

export default function Advertisement({posterUrl} : AdProp){
    return (
        <div>
            <img src={posterUrl} width={250} height={400}/>
        </div>
    )
}
