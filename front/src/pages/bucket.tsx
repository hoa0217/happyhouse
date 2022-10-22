import { useRouter } from "next/router";
import { useSelector } from "react-redux";

const Bucket = () =>{

    const { token } = useSelector((state:any) => state.login)
    const router = useRouter();
    
    if (!token) router.push('/login'); 

    return (
        <div>내가찜한집</div>
    )
}

export default Bucket;