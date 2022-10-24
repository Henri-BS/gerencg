import { AUTH_FAILURE, AUTH_REQ, AUTH_SUCCESS } from "types/authTypes";

const initialState = {
  users: {},
  error: "",
  loading: false,
};

const auth = (state = initialState, action: any) => {
  switch (action.type) {
    case AUTH_REQ:
      return { ...state, error: "", loading: true };

    case AUTH_SUCCESS:
const data = action.payload;
    return { ...state, error:'', loading:false, user: data };

    case AUTH_FAILURE:
      const error = action.payload;
      return { ...state, loading: false, error: error };

    default:
      return state;
  }
};

export default auth;
