import { AUTH_FAILURE, AUTH_REQ, AUTH_SUCCESS } from "types/authTypes";

export const authenticate = () => {
    return {
        type:AUTH_REQ
    }
}

export const authSuccess = (content: { token: string; }) => {
    localStorage.setItem('USER_KEY', content.token);
    return {
        type: AUTH_SUCCESS,
        payload: content
    }
}

export const authFailure = (error: any) => {
 
    return {
        type: AUTH_FAILURE,
        payload: error
    }
}