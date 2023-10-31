import React from 'react';
import Ad from '../advertisement/Advertisement';
import './leftbar.css'
import Advertisement from '../advertisement/Advertisement';
import { ad1PosterUrl,ad2PosterUrl,ad3PosterUrl } from '../../constants';

export default function Leftbar(){

    return (
        <div className='leftbar'>
            <div className="leftbarWrapper">
                <ul className="leftbarFriendList">
                    <Advertisement posterUrl={ad1PosterUrl}/>
                </ul>
            </div>
        </div>
    )
} 