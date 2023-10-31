import React from 'react'
import { Person, Chat, Notifications } from "@mui/icons-material";
import SearchIcon from '@mui/icons-material/Search';
import "./topbar.css"

export default function Topbar(){
    return (
        <div className="topbarContainer">
            <div className="topbarLeft">
                <a className="logo">Askme</a>
            </div>
            <div className="topbarCentre">
                {/*<div className="searchbar">
                    <SearchIcon/>
                    <input placeholder="Search for questions , spaces or any user" className="searchInput" />
                    </div> */}
            </div>
            <div className="topbarRight">
                <div className="topbarLinks">
                    <span className="topbarLink">Home Page</span>
                    <span className="topbarLink">Timeline</span>
                </div>
                <div className="topbarIcons">
                    <div className="topbarIconItem">
                        <Person />
                        <span className="topbarIconBadge">1</span>
                    </div>
                    <div className="topbarIconItem">
                        <Chat/>
                        <span className="topbarIconBadge">2</span>
                    </div>
                    <div className="topbarIconItem">
                        <Notifications/>
                        <span className="topbarIconBadge">1</span>
                    </div>
                </div>
                <img src="assets/dp.png" alt="" className="topbarImg" />
            </div>
        </div>
    )
}