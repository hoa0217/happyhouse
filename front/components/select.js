import React from 'react'
import { Select } from 'semantic-ui-react'

const SelectExample = ({list,setGeo}) => {

  const countryOptions = list.map(el => {
    return (
      {
        key:el.cortarNo,
        value: el.cortarName,
        text:el.cortarName
      }
    )
  })
  
  const si = (event) => {
    setGeo([event.target.innerText])
  }

  return (
      <Select  options={countryOptions} defaultValue={'서울시'} onChange={si}/>
  )
}

export default SelectExample