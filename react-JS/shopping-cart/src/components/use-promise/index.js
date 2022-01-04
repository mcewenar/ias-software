import React from "react";


function usePromise(promiseFactory) {
  const [isLoading, setLoading] = React.useState(true);
  const [error, setError] = React.useState();
  const [data, setData] = React.useState();

  React.useEffect(() => {
    promiseFactory()
      .then((jsonResponse) => setData(jsonResponse))
      .catch((error) => setError(error))
      .finally(() => setLoading(false));
  }, []);

  return {
    isLoading,
    data,
    error,
  };
}

export default usePromise;