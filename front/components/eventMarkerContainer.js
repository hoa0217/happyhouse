import { MapMarker, useMap } from "react-kakao-maps-sdk"
import React, { useState } from "react"

const EventMarkerContainer = ({ position, content }) => {
    const map = useMap();
    const [isVisible, setIsVisible] = useState(false)

    return (
      <MapMarker
        position={position}
        onClick={(marker) => map.panTo(marker.getPosition())}
        onMouseOver={() => setIsVisible(true)}
        onMouseOut={() => setIsVisible(false)}
      >
        {isVisible && content}
      </MapMarker>
    )
  }

  export default EventMarkerContainer;