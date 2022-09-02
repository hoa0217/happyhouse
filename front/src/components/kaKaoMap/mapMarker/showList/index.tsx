import React, { useState } from 'react';

// interface ShowListProps{
// 	houseData:
// }

export default function ShowList({ houseData }) {
  if (!houseData) return; //처음실행할때 undefined 방지

  const {
    data: { houseOnSaleJEONSEList, houseOnSaleMAEMAEList, houseOnSaleWOLSEList },
  } = houseData;

  return (
    <div
      style={{
        position: 'fixed',
        width: '20vw',
        height: '100vh',
        backgroundColor: 'white',
        top: '32px',
        left: '0px',
        zIndex: '10',
      }}
    ></div>
  );
}
