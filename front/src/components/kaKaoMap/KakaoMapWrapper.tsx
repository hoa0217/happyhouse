import { ReactNode } from "react";

interface KakaoMapWrapperProps{
    children : ReactNode
}

const KakaoMapWrapper = ({children} : KakaoMapWrapperProps) => {
    return (
        <div>{children}</div>
    )
}

export default KakaoMapWrapper;