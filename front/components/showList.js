import React, { useState } from "react";

export default function ShowList({houseData}){

    if(!houseData) return ;//처음실행할때 undefined 방지 
    
    const {data : {houseOnSaleJEONSEList, houseOnSaleMAEMAEList, houseOnSaleWOLSEList}} = houseData;
    return (
        <div style={{'position':'fixed', 'width':'20vw','height':'100vh','backgroundColor':'white','top':'32px','left':'0px','zIndex':'10'}}>
            {
                //매물을 클릭했을 때 detail페이지로 이동
                houseOnSaleJEONSEList.map((list,id)=> (
                        <div onClick={() => console.log(list.houseOnSaleId)} key={id}>
                            <div>욕실수 : {list.bathCount}</div>
                            <div>거래유형 : {list.dealType}</div>
                            <div>전용면적 : {list.netLeasableArea}</div>
                            <div>기타 등등</div>
                        </div>
                ))
            }
        </div>
    )    
}