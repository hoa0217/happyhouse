export default interface LoginRs {
  data: string;
  message: string;
  responseCode:
    | 'BAD_REQUEST'
    | 'CONFLICT'
    | 'CREATED'
    | 'DB_ERROR'
    | 'FORBIDDEN'
    | 'INTERNAL_SERVER_ERROR'
    | 'NOT_FOUND'
    | 'NO_CONTENT'
    | 'OK'
    | 'SERVICE_UNAVAILABLE'
    | 'UNAUTHORIZED';
}
