import { AUTH_FAILURE, AUTH_REQ, AUTH_SUCCESS, LOGIN_REQUEST, LOGOUT_REQUEST } from "types/authTypes";

//Auth Actions

export const authenticate = () => {
  return {
    type: AUTH_REQ,
  };
};

export const authSuccess = (content: { token: string }) => {
  localStorage.setItem("USER_KEY", content.token);
  return {
    type: AUTH_SUCCESS,
    payload: content,
  };
};

export const authFailure = (error: any) => {
  return {
    type: AUTH_FAILURE,
    payload: error,
  };
};

//Auth Reducer

const initialState = {
  userName: "",
  isLoggedIn: "",
};

export const authReducer = (state = initialState, action: any) => {
  switch (action.type) {
    case LOGIN_REQUEST:
    case LOGOUT_REQUEST:
      return {
        ...state,
      };
    case AUTH_SUCCESS:
    case AUTH_FAILURE:
      return {
        username: action.payload.username,
        isLoggedIn: action.payload.isLoggedIn,
      };
    default:
      return state;
  }
};

